package com.cognizant.ams.controller.sn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.alibaba.fastjson.JSONArray;
import com.cognizant.ams.bean.SmConfig;
import com.cognizant.ams.bean.SmSn;
import com.cognizant.ams.bean.common.JsonReqObject;
import com.cognizant.ams.common.ExcelUtils;
import com.cognizant.ams.common.utils.DateFormatUtils;
import com.cognizant.ams.common.utils.ExpressPattern;
import com.cognizant.ams.service.SnService;

@RestController
public class ExcleController {

	@Autowired
	private SnService snService;

	@PostMapping("/upload")
	public String doUpload(HttpServletRequest request) throws IOException {
		MultipartHttpServletRequest mreq = null;
		if (request instanceof MultipartHttpServletRequest) {
			mreq = (MultipartHttpServletRequest) request;
		} else {
			return "请上传excle格式文件!";
		}
		try {
			boolean flag = analysisFile(mreq);
			if (!flag) {
				return "excle解析失败";
			}
			return "excle上传成功";
		} catch (Exception e) {
			return "excle解析失败";
		}
	}

	@SuppressWarnings("rawtypes")
	public boolean analysisFile(MultipartHttpServletRequest mreq) {
		List<Map> maps = null;
		List<SmSn> snList = new ArrayList<SmSn>();
		List<SmConfig> slaList=snService.getSLAStandard();
		SmSn smSn = null;
		
		try {
			maps = ExcelUtils.analysisFile(mreq);
			int i =0;
			for (Map map : maps) {
				System.out.println("=========================="+i++);
				smSn = new SmSn();
				@SuppressWarnings("unchecked")
				Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
				int reso=0;
				String state = "";
				String com = "";
				String reason = "";
				String message="";
				while (it.hasNext()) {
					Map.Entry<String, String> entry = it.next();

					if (entry.getKey().equals("Number")) {
						smSn.setTicketNo(entry.getValue());
					}
					if (entry.getKey().equals("Assignment group")) {
						smSn.setAssignmentGroup(entry.getValue());
					}
					if (entry.getKey().equals("Priority")) {
						smSn.setPriority(entry.getValue());
					}

					if (entry.getKey().equals("Configuration item")) {
						smSn.setAppName(entry.getValue());
					}

					if (entry.getKey().equals("Assigned to") ) {
						smSn.setAssignTo(entry.getValue());
					}

					if (entry.getKey().equals("Caller") || entry.getKey().equals("Requested for")) {
						smSn.setCaller(entry.getValue());
					}
					if (entry.getKey().equals("Work notes")) {    //提取分配时间和响应时间
						message = entry.getValue();
						//System.out.println("workNotes==" + message);
						if (message!=null&&!message.equals("")) {

						String createTime = ExpressPattern.assignTime(message);
						String wipTime = ExpressPattern.wipTime(message);
						if (!wipTime.equals("")) {
							//String wipDiff = DateFormatUtils.dateDiff(createTime, wipTime) + "分钟";
							String wipDiff = DateFormatUtils.workDateDiff(createTime, wipTime) + "分钟";
							smSn.setWipTime(wipDiff);
						} 
						smSn.setCreateTime(createTime);
						}
					}

					if (entry.getKey().equals("Incident state")) {
						state = entry.getValue();
						smSn.setIncidentState(state);
					}
					if (entry.getKey().equals("Comments and Work notes") || entry.getKey().equals("Additional comments") ) {
						 com = entry.getValue();
					}
					if (entry.getKey().equals("Pending reason")) {
						reason = entry.getValue();
					}
					//等待所有的字段获取完毕，统一处理。===============================
					if (!state.equals("")&&!com.equals("")&&!message.equals("")) {
						String resolveDiff = null;
						if (smSn.getTicketNo().contains("TASK")) {
							com = message;
						}
						String pendingTime = ExpressPattern.pedingTime(com);
						//System.out.println(smSn.getCreateTime());
						//System.out.println(DateFormatUtils.getDateMH());
						int a = Integer.parseInt(DateFormatUtils.workDateDiff(smSn.getCreateTime(), DateFormatUtils.getDateMH()));  //工单建立多久了
						//当IT没有填写worknote时候就需要计算  未响应的时间
						int resp=0;
						//根据工单类型来判断响应标准时间。
						for (SmConfig smConfig : slaList) {
								if (smSn.getTicketNo().contains(smConfig.getCkey())&&smSn.getPriority().equals(smConfig.getCval1())) {
									resp=Integer.parseInt(smConfig.getCval2());
									reso=Integer.parseInt(smConfig.getCval3());
								}
						}
						String closeTime = ExpressPattern.ResolvedTime(com);
						if (state.equals("Work in progress")&&(smSn.getWipTime()==null||smSn.getWipTime().equals(""))) {
							
							if (a <= resp) {
								smSn.setSlaFlag("最晚响应时间是："+DateFormatUtils.nextWorkDate(DateFormatUtils.getDateMH(), (resp-a)+""));
							}
							
							if (a > resp) {
								smSn.setSlaFlag("响应超时");
							}
						}
						if (state.equals("Work in progress")&&(smSn.getWipTime()!=null&&!smSn.getWipTime().equals(""))) {
							
							if (a <= reso) {
								smSn.setSlaFlag("最晚解决时间是："+DateFormatUtils.nextWorkDate(DateFormatUtils.getDateMH(), (reso-a)+""));
							}
							if (a > reso) {
								smSn.setSlaFlag("解决超时");
							}
						}
						
						if (state.equals("Pending")) {
							
							smSn.setPendingTime(pendingTime);
							
							if (a>0 && a<= 1440) {
								smSn.setSlaFlag("0-3天内未解决");
							}
							else if (a>1440 && a<= 2880) {
								smSn.setSlaFlag("4-6内天未解决");
							}
							else if (a>2880 && a<= 4800) {
								smSn.setSlaFlag("7-10内天未解决");
							}
							else if (a>4800&& a<= 7200) {
								smSn.setSlaFlag("11-15内天未解决");
							}
							else {
								smSn.setSlaFlag("超15天未解决");
							}
						}
						
						if (smSn.getIncidentState().equals("Resolved")) {
							smSn.setResolvedTime(closeTime);
							message =com.toLowerCase();
							if (!reason.equals("")) {
								if(message.contains("pen")) {
									pendingTime=ExpressPattern.resolvedPedingTime(message,com);
									smSn.setPendingTime(pendingTime);
									resolveDiff = DateFormatUtils.workDateDiff(pendingTime,closeTime );
									System.out.println("解决时间中，找到pendingTime");
								}
								else {
									resolveDiff="500";
								}
								
							}
							else if(smSn.getResolvedTime() != null && !smSn.getResolvedTime().equals("")) {
								resolveDiff = DateFormatUtils.workDateDiff(smSn.getCreateTime(),closeTime );
							}
							else {
								resolveDiff = "481";
							}
							int resolveDiff1 = Integer.parseInt(resolveDiff);
							
							if (resolveDiff1 <= reso) {
								smSn.setSlaFlag("达标");
							} else {
								if (resolveDiff1==500) {
									smSn.setSlaFlag("不合格(pending时worknote必须包含pending关键字)");
								}else {
									smSn.setSlaFlag("不达标");
								}
								
							}
						}
					
					}
					
				}
				
				snList.add(smSn);
			}

			// System.out.println(snList);
			snService.saveOrUpdateSN(snList);

		} catch (Exception e) {
			return false;
		}
		if (maps == null) {
			return false;
		} else {
			return true;
		}
	}

	@PostMapping("/fenyeQuerySN")
	public Map<String, Object> fenyeQuerySN(@RequestBody String param) {
		System.out.println("分页查询参数===" + param);
		JsonReqObject jsonReqObject = JSONArray.parseObject(param, JsonReqObject.class);
		String jsonParam = jsonReqObject.getMsg();
		SmSn smSntlist = JSONArray.parseObject(jsonParam, SmSn.class);
		// 查询配置
		List<SmSn> list = snService.queryFenyeSN(smSntlist);

		// 上述拿到完整list，现在进行分页返回当前页面数据。
		System.out.println("总条数为===" + list.size());
	
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("list", list);
		return map;
	}

}
