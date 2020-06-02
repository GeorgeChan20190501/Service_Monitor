package com.cognizant.ams.controller.effort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cognizant.ams.bean.SmConfig;
import com.cognizant.ams.bean.SmEfforts;
import com.cognizant.ams.bean.SmSn;
import com.cognizant.ams.bean.common.JsonReqObject;
import com.cognizant.ams.common.ExcelUtils;
import com.cognizant.ams.common.utils.DateFormatUtils;
import com.cognizant.ams.common.utils.ExpressPattern;
import com.cognizant.ams.service.EffortService;

@RequestMapping("/efforts")
@RestController
public class EffortController {

	@Autowired
	private EffortService effortService;

	private static String loginUsercode;

	private static String message="";

	@PutMapping("/save")
	public int saveEfforts(@RequestBody String effortJson) {
		System.out.println("开始保存effort===" + effortJson);

		JSONObject json = JSON.parseObject(effortJson);
		System.out.println(effortJson);
		SmEfforts effort = new SmEfforts();
		effort.setWorkday(json.getString("workday"));
		effort.setEaiCode(json.getString("eaicode"));
		effort.setTasktype(json.getString("tasktype"));
		effort.setTicketNumber(json.getString("ticketnumber"));
		effort.setEffortsHours(json.getString("efforthours"));

		// 插入关联数据
		SmConfig temp = effortService.queryAppConfig("applist", effort.getEaiCode(), "");

		effort.setAppname(temp.getCval1());
		effort.setAppower(temp.getCval2());
		// TODO 获取当前登陆用户
		effort.setUserid(json.getString("userid"));
		effort.setUsername(json.getString("username"));

//		effort.setUserid("likev");
//		effort.setUsername("Kevin");

		int result = effortService.save(effort);
		return result;
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping("/applist")
	public List<SmConfig> getAppList() {
		List<SmConfig> applists = effortService.queryAppConfig();
		return applists;
	}

	@PostMapping("/query")
	public Map<String, Object> queryEffortByUser(@RequestBody String param) {
		System.out.println("@@@传入JSON" + param);
		String usercode = "";
		String startworkdy = "";
		String endworkday = "";
		JsonReqObject jsonReqObject = JSONArray.parseObject(param, JsonReqObject.class);
		String jsonParam = jsonReqObject.getMsg();
		if (Strings.isEmpty(jsonParam)) {
			JSONObject object = JSONObject.parseObject(param);
			usercode = object.getString("usercode");
			startworkdy = object.getString("startworkday");
			endworkday = object.getString("endworkday");
		} else {
			JSONObject object = JSONObject.parseObject(jsonParam);
			usercode = object.getString("usercode");
			startworkdy = object.getString("startworkday");
			endworkday = object.getString("endworkday");
		}

		Map<String, Object> map = new HashMap<String, Object>();
		// 页面加载时查询
		System.out.println("#########EFFORT查询：usercode===" + usercode + "startworkdy===" + startworkdy + "endworkday==="
				+ endworkday);
		if (Strings.isEmpty(usercode)) {// 传入usercode为空

			if (null != loginUsercode && (!loginUsercode.equals("SYSTEM"))) {// 普通用户
				List<SmEfforts> effortList = effortService.queryEffortsByUser(loginUsercode);
				map.put("list", effortList);
				return map;
			} else {// admin用户
				List<SmEfforts> effortList = effortService.queryAllEfforts();
				map.put("list", effortList);
				return map;
			}

		} else {// 传入usercode为不为空（页面查询）
			System.out.println("&&&&&&&&&&&进来了");
			if (usercode.equals("ams")) {

				// 获取团队Efforts
				List<SmEfforts> effortList = effortService.queryAllEffortsByDate(startworkdy, endworkday);
				map.put("list", effortList);
				return map;
			} else {
				System.out.println();
				// 获取个人Effort
				System.out.println(usercode + "查询所有effort");
				List<SmEfforts> effortList = effortService.queryEfforts(startworkdy, endworkday, usercode);
				map.put("list", effortList);
				return map;
			}

		}
	}

	@GetMapping("/allefforts")
	public List<SmEfforts> queryEffortAll() {
		return effortService.queryAllEfforts();
	}

	@PostMapping("/update")
	public String updateEffort(@RequestBody String param) {
		int result = 0;
		JsonReqObject jsonReqObject = JSONArray.parseObject(param, JsonReqObject.class);
		String jsonParam = jsonReqObject.getMsg();
		System.out.println("修改Effort参数===" + jsonParam);
		String Roles[] = jsonReqObject.getMsg().replace("\\", "").replace("}\",", "}\";").replace("[\"", "")
				.replace("\"]", "").split("\";\"");
		List<SmEfforts> list = new ArrayList<SmEfforts>();
		SmEfforts sysRole;
		for (String Role : Roles) {
			sysRole = JSONArray.parseObject(Role, SmEfforts.class);
			list.add(sysRole);
		}
		try {
			result = effortService.update(list);
		} catch (Exception e) {
			return "操作异常";
		}
		return "Effort更新成功" + result + "条";
	}

	@DeleteMapping("delete")
	public String deleteEffort(@RequestBody String param) {
		System.out.println("删除Effort参数===" + param);
		JsonReqObject jsonReqObject = JSONArray.parseObject(param, JsonReqObject.class);
		String jsonParam = jsonReqObject.getMsg();
		String ids[] = jsonParam.replace("[", "").replace("]", "").split(",");
		List<String> list = new ArrayList<String>();
		for (String id : ids) {
			list.add(id);
		}
		System.out.println(list);
		int result = effortService.delete(list);
		return "删除成功" + result + "条！";
	}

	@GetMapping("/loginuser")
	public String getSessionUser(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		loginUsercode = (String) session.getAttribute("username");
		System.out.println("获取Session用户：" + loginUsercode);

		return loginUsercode;
	}

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
				if (Strings.isNotBlank(message)) {
					return message;
				}
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
		List<SmEfforts> effortList = new ArrayList<SmEfforts>();

		SmEfforts effort = null;
		int monthhours = 0;
		String effortUser = null;
		String effortUserid = null;
		try {
			maps = ExcelUtils.analysisFileFirstSheet(mreq);
			String fileName = mreq.getFile("file").getOriginalFilename();

			int startindex = fileName.indexOf("_");
			int endindex = fileName.indexOf(".");
			if (endindex - startindex != 7) {
				message = "uplaod format error!  eq:  Effort Tracker George_202006";
				return false;
			}
			String YearMonth = fileName.substring(startindex + 1, startindex + 7);

			int i = 0;
			for (Map map : maps) {
				System.out.println("==========================" + i++);
				effort = new SmEfforts();
				@SuppressWarnings("unchecked")
				Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry<String, String> entry = it.next();
					if (entry.getKey().trim().equalsIgnoreCase("Date")) {
						effort.setWorkday(entry.getValue());
					}
					if (entry.getKey().trim().equalsIgnoreCase("Associate Name")) {
						effort.setUsername(entry.getValue());
						if (Strings.isNotBlank(entry.getValue())) {
							effortUser = entry.getValue();
						}

					}
					if (entry.getKey().trim().equalsIgnoreCase("Task Type")) {
						effort.setTasktype(entry.getValue());
					}
					if (entry.getKey().trim().equalsIgnoreCase("EAI Code")) {
						effort.setEaiCode(entry.getValue());
					}
					if (entry.getKey().trim().equalsIgnoreCase("Ticket Number")) {
						effort.setTicketNumber(entry.getValue());
					}
					if (entry.getKey().trim().equalsIgnoreCase("Hours")) {
						effort.setEffortsHours(entry.getValue());
					}

					if (entry.getKey().trim().equalsIgnoreCase("AD Owner")) {
						effort.setAppower(entry.getValue());
					}
					if (entry.getKey().trim().equalsIgnoreCase("Application Name")) {
						effort.setAppname(entry.getValue());
					}

					// 对当前行effort校验，ticketnum不为空则可以插入

				}
				if (null != effort) {
					if (Strings.isNotBlank(effort.getTicketNumber())) {
						if (Strings.isNotBlank(effort.getEffortsHours()) && Strings.isNotBlank(effort.getEaiCode())) {
							monthhours += Integer.parseInt(effort.getEffortsHours());
							effortList.add(effort);
						} else {
							System.out.println("Hours,Eaicode不能为空");
							message = "Hours,Eaicode不能为空";
							return false;
						}

					}

					// 关联数据插入
					// 插入关联数据
					String  eaiString=effort.getEaiCode();
					if (null!=eaiString&&effort.getEaiCode().indexOf(".") != -1) {
						effort.setEaiCode(effort.getEaiCode().substring(0, effort.getEaiCode().indexOf(".")));// qu
																												// xiaoshudian
					}

					SmConfig temp = effortService.queryAppConfig("applist", effort.getEaiCode(), "");

					effort.setAppname(temp.getCval1());
					effort.setAppower(temp.getCval2());
					// userid 匹配
					SmConfig temp1 = effortService.queryAppConfig("effortuserlist", "", effortUser);

					effort.setUserid(temp1.getCkey());
					if (Strings.isNotBlank(temp1.getCkey())) {
						effortUserid = temp1.getCkey();
					}
				}

			}
			// 遍历结束
for (SmEfforts smEfforts : effortList) {
	double temphours=0;
	for (SmEfforts smEfforts2 : effortList) {
		if (smEfforts2.getWorkday().equals(smEfforts.getWorkday())&&smEfforts2.getUserid().equals(smEfforts.getUserid())) {
			temphours+=Double.parseDouble((smEfforts2.getEffortsHours()));
		}
	}
	if (temphours<8.0||temphours>12.0) {
		message=message+smEfforts.getWorkday()+"的时长不符合要求</br>";
		
	}
	
}
			if (Strings.isNotBlank(message)) {
				return false;
			}
			
			// TODO 获取当月小时数,开始时间，结束时间
			int workday = Integer.parseInt(effortService.queryAppConfig("monthhourslist", YearMonth, "").getCval3());
			String starttime = effortService.queryAppConfig("monthhourslist", YearMonth, "").getCval1();
			String endtime = effortService.queryAppConfig("monthhourslist", YearMonth, "").getCval2();
			if (monthhours < workday * 8) {
				message = "工时不足" + workday * 8 + "小时";
				return false;
			}
			System.out.println(effortList);
			int delresult = effortService.deleteEffortsByDate(effortUserid, starttime, endtime);
			System.out.println(effortUser + "删除effort" + delresult);
			int insert = effortService.saveOrUpdateEffort(effortList);
			System.out.println(effortUser + "新增effort" + insert);

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
		if (maps == null) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		System.out.println("10281".substring(0, "10281".indexOf(".")));
	}

}
