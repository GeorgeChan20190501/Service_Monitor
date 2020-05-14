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
import com.cognizant.ams.bean.SmSn;
import com.cognizant.ams.bean.common.JsonReqObject;
import com.cognizant.ams.common.ExcelUtils;
import com.cognizant.ams.common.utils.DateFormatUtils;
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
		SmSn smSn = null;
		
		try {
			maps = ExcelUtils.analysisFile(mreq);
			for (Map map : maps) {
				smSn = new SmSn();
				@SuppressWarnings("unchecked")
				Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
				String pendingTime = "";
				String state = "";
				String com = "";
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

					if (entry.getKey().equals("Assigned to")) {
						smSn.setAssignTo(entry.getValue());
					}

					if (entry.getKey().equals("Caller")) {
						smSn.setCaller(entry.getValue());
					}
					if (entry.getKey().equals("Work notes")) {
						String workNotes = entry.getValue();
						System.out.println("workNotes" + workNotes);
						String createTime = workNotes.substring(workNotes.lastIndexOf(" - ") - 19,
								workNotes.lastIndexOf(" - "));
						String wipTime = workNotes.substring(0, workNotes.lastIndexOf(createTime));
						if (wipTime.contains(" - ")) {
							wipTime = wipTime.substring(wipTime.lastIndexOf(" - ") - 19, wipTime.lastIndexOf(" - "));
							String wipDiff = DateFormatUtils.dateDiff(createTime, wipTime) + "分钟";
							smSn.setWipTime(wipDiff);
						} else {
							int a = Integer.parseInt(DateFormatUtils.dateDiff(DateFormatUtils.getDateHM(), createTime));

							if (a > 0 && a <= 30) {
								smSn.setSlaFlag("0-30分钟内未响应");
							}

							if (a > 30 && a <= 60) {
								smSn.setSlaFlag("30-60分钟内未响应");
							}
							if (a > 60 && a <= 90) {
								smSn.setSlaFlag("60-90分钟内未响应");
							}

							if (a > 90 && a <= 120) {
								smSn.setSlaFlag("90-120分钟内未响应");
							}
							if (a > 120) {
								smSn.setSlaFlag("响应超时");
							}
						}
						pendingTime = workNotes.substring(workNotes.indexOf(" - ") - 19, workNotes.indexOf(" - "));

						smSn.setCreateTime(DateFormatUtils.formatAP(createTime));
					}

					if (entry.getKey().equals("Incident state")) {
						state = entry.getValue();
						
						smSn.setIncidentState(state);
						int a = Integer.parseInt(
								DateFormatUtils.dateDiff(smSn.getCreateTime(), DateFormatUtils.getDateHM()));
						if (state.equals("Pending")) {
							smSn.setPendingTime(DateFormatUtils.formatAP(pendingTime));
							if (a > 0 && a < 4320) {
								smSn.setSlaFlag("0-3天内未解决");
							}
							if (a > 4320 && a < 7200) {
								smSn.setSlaFlag("3-5天内未解决");
							}
							if (a > 7200 && a < 11520) {
								smSn.setSlaFlag("5-8天内未解决");
							}
							if (a > 11520 && a < 21600) {
								smSn.setSlaFlag("8-15天内未解决");
							}
							if (a > 21600) {
								smSn.setSlaFlag("超15天未解决");
							}
						}
						if (state.equals("Work in progress")&&(smSn.getWipTime()==null||smSn.getWipTime()
								.equals(""))) {
							smSn.setSlaFlag(a+"分钟未响应");
						}
						
						if (state.equals("Work in progress")&&smSn.getWipTime()!=null&&!smSn.getWipTime()
								.equals("")) {
							if (a<480) {
								
								smSn.setSlaFlag("剩余"+a+"分钟解决时间");
							}
							else {
								smSn.setSlaFlag("解决超时");
							}
							
						}

					}
					if (entry.getKey().equals("Comments and Work notes")) {
						 com = entry.getValue();
					}
					if (!state.equals("")&&!com.equals("")) {
						String resolveDiff = null;
						String closeTime = com.substring(com.indexOf(" - ") - 19, com.indexOf(" - "));
						
						if (smSn.getIncidentState().equals("Resolved")) {
							smSn.setResolvedTime(DateFormatUtils.formatAP(closeTime));
							if (smSn.getPendingTime() != null && !smSn.getPendingTime().equals("")) {
								resolveDiff = DateFormatUtils.dateDiff(smSn.getPendingTime(), smSn.getCreateTime());
							} else {
								resolveDiff = DateFormatUtils.dateDiff(closeTime, smSn.getCreateTime());
							}
							int resolveDiff1 = Integer.parseInt(resolveDiff);
							if (resolveDiff1 < 480) {
								smSn.setSlaFlag("达标");
							} else {
								smSn.setSlaFlag("不达标");
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
