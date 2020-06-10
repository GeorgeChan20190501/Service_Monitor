package com.cognizant.ams.controller.effort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import org.thymeleaf.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cognizant.ams.bean.SmConfig;
import com.cognizant.ams.bean.SmEfforts;
import com.cognizant.ams.bean.SysUser;
import com.cognizant.ams.bean.common.JsonReqObject;
import com.cognizant.ams.common.ExcelUtils;
import com.cognizant.ams.common.utils.DateCal;
import com.cognizant.ams.common.utils.DateFormatUtils;

import com.cognizant.ams.service.EffortService;
import com.cognizant.ams.service.UserService;

@RequestMapping("/efforts")
@RestController
public class EffortController {

	@Autowired
	private EffortService effortService;

	@Autowired
	private UserService userService;

	private static String loginUsercode;
	private static String effortuser;
	private static String message = "";

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
		List<SmConfig> temp = effortService.queryAppConfig("applist", effort.getEaiCode(), "");
		if (null != temp && temp.size() > 0) {
			effort.setAppname(temp.get(0).getCval1());
			effort.setAppower(temp.get(0).getCval2());
		}

		// TODO 获取当前登陆用户
		effort.setUserid(json.getString("userid"));
		
		//更新ID的用户名为最新username
		SysUser sysUser=new SysUser();
		sysUser.setAccount(json.getString("userid"));
		List<SysUser> users = userService.queryUser(sysUser);
		if (users != null && users.size() > 0) {
			String username = users.get(0).getUsername();
			if (Strings.isNotBlank(username)) {
				effort.setUsername(username);
			}else {
				effort.setUsername(loginUsercode);
			}
			
		}
		
		
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

	@GetMapping("/users")
	public List<SysUser> queryUserAll() {

		List<SysUser> list = userService.getusers();
		System.out.println("总条数为===" + list.size());
		return list;
	}

	@PostMapping("/upload")
	public String doUpload(HttpServletRequest request, String effortuser, String startworkday, String endworkday)
			throws IOException {
		message = "";// 重置
		System.out.println("&&" + effortuser);
		System.out.println("&&" + startworkday);
		System.out.println("&&" + endworkday);
		this.effortuser = effortuser;
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
		Double monthhours = 0.0;
		String effortUser = null;
		String effortUserid = null;
		try {
			maps = ExcelUtils.analysisFileFirstSheet(mreq);
			String fileName = mreq.getFile("file").getOriginalFilename();

			int startindex = fileName.indexOf("_");
			int endindex = fileName.indexOf(".");
			if (endindex - startindex != 7) {
				message = "Effort格式有误！  例如:  Effort Tracker George_202006";
				return false;
			}
			String YearMonth = fileName.substring(startindex + 1, startindex + 7);

			int i = 0;
			for (Map map : maps) {
				if (null == map) {
					continue;
				}
				System.out.println("==========================ff" + i++);
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
					if (Strings.isNotBlank(effort.getTicketNumber())) {//有effort内容时
						if (!"Management".equals(effort.getTasktype())) {//非Management类  需要填内容，应用code，工时
							if (Strings.isNotBlank(effort.getEffortsHours())
									&& Strings.isNotBlank(effort.getEaiCode())) {
								System.out.println("------gg" + effort.getEffortsHours());
								monthhours += Double.parseDouble(effort.getEffortsHours());
								effortList.add(effort);

							} else {
								System.out.println("Hours,Eaicode不能为空");
								message = "Hours,Eaicode不能为空";
								return false;
							}
						} else {//Management类  需要填内容，其他可不填
							if (Strings.isNotBlank(effort.getEffortsHours())) {
								System.out.println("------gg" + effort.getEffortsHours());
								monthhours += Double.parseDouble(effort.getEffortsHours());
								effortList.add(effort);

							} else {
								System.out.println("Hours不能为空");
								message = "Hours不能为空";
								return false;
							}
						}
					} else {// 请假 管理 可不填effort内容
						if ("Vacation".equals(effort.getTasktype()) ) {//请假 eai，内容均可不填
							if (Strings.isNotBlank(effort.getEffortsHours())) {
								System.out.println("------gg" + effort.getEffortsHours());
								monthhours += Double.parseDouble(effort.getEffortsHours());
								effortList.add(effort);

							} else {
								System.out.println("Hours不能为空");
								message = "Hours不能为空";
								return false;
							}
						}
					}

					if (Strings.isNotBlank(effort.getWorkday())) {
						String date = effort.getWorkday();
						String celldatem = date.substring(0, 4).concat(date.substring(5, 7));
						if (!YearMonth.equals(celldatem)) {
							message = "包含非" + YearMonth + "的Effort数据！请删除后导入";
							return false;
						}
					}

					// 关联数据插入
					// 插入关联数据
					if (Strings.isNotBlank(effort.getEaiCode())) {
						String eaiString = effort.getEaiCode();
						if (null != eaiString && effort.getEaiCode().indexOf(".") != -1) {
							effort.setEaiCode(effort.getEaiCode().substring(0, effort.getEaiCode().indexOf(".")));// qu
																													// xiaoshudian
						}

						List<SmConfig> temp = effortService.queryAppConfig("applist", effort.getEaiCode(), "");
						if (null != temp && temp.size() > 0) {
							effort.setAppname(temp.get(0).getCval1());
							effort.setAppower(temp.get(0).getCval2());
						} else {
							message = "包含未配置的EAICODE: " + effort.getEaiCode();
							return false;
						}

					}

					// userid 匹配
					if ("SYSTEM".equals(loginUsercode)) {

					} else {
						effortuser = loginUsercode;
					}

					effort.setUserid(effortuser);
					SysUser sysUser = new SysUser();
					sysUser.setAccount(effortuser);
					List<SysUser> users = userService.queryUser(sysUser);
					if (users != null && users.size() > 0) {
						String username = users.get(0).getUsername();
						if (Strings.isNotBlank(username)) {
							effort.setUsername(username);
						}else {
							effort.setUsername(effortuser);
						}
						
					}
					else {// 未登陆用户选择账号作为effortower
						effort.setUsername(effortuser);
					}

					// tasktype 统一
					if (Strings.isNotBlank(effort.getTicketNumber())) {
						if (effort.getTicketNumber().toUpperCase().contains("INC")) {
							effort.setTasktype("Production - Incident Management (AP)");
							System.out.println("&&&&&===" + effort.getTicketNumber());
						}
						if (effort.getTicketNumber().toUpperCase().contains("TASK")) {
							effort.setTasktype("Production - Service Management (DP / DR / UC)");
							System.out.println("&&&&&===" + effort.getTicketNumber());
						}
						if (effort.getTicketNumber().toUpperCase().contains("PRB")
								|| effort.getTicketNumber().toUpperCase().contains("PTASK")) {
							effort.setTasktype("Production - Problem Management (IAP)");
							System.out.println("&&&&&===" + effort.getTicketNumber());
						}
					}

				}

			}
			// 遍历结束
			for (SmEfforts smEfforts : effortList) {
				double temphours = 0.0;
				for (SmEfforts smEfforts2 : effortList) {
					//
					if (smEfforts2.getWorkday().equals(smEfforts.getWorkday())) {
						temphours += Double.parseDouble((smEfforts2.getEffortsHours()));
					}
				}
				boolean isworkday = true;
				Calendar calendar = DateFormatUtils.transCanlendar1(smEfforts.getWorkday());

				if ((DateCal.isHodliDays(calendar) || DateCal.isWeek(calendar)) && !(DateCal.isPlusDay(calendar))) {
					isworkday = false;
				}

				if (isworkday && (temphours < 8.0 || temphours > 24.0)) {
					message = message + smEfforts.getWorkday() + "的时长不符合要求；";

				}

			}
			if (Strings.isNotBlank(message)) {
				return false;
			}

			// TODO 获取当月小时数,开始时间，结束时间
			int workday = 0;
			String starttime = "";
			String endtime = "";
			List<SmConfig> configs = effortService.queryAppConfig("monthhourslist", YearMonth, "");
			if (null != configs && configs.size() > 0) {
				workday = Integer.parseInt(configs.get(0).getCval3());
				starttime = configs.get(0).getCval1();
				endtime = configs.get(0).getCval2();
			} else {
				message = "本月effort工时未配置！";
				return false;
			}
			System.out.println("effort行数====" + effortList.size());
			if (monthhours < workday * 8) {
				message = "工时不足" + workday * 8 + "小时";
				return false;
			}
			System.out.println(effortList);
			int delresult = effortService.deleteEffortsByDate(effortuser, starttime, endtime);
			System.out.println(effortuser + "删除effort" + delresult);
			int insert = effortService.saveOrUpdateEffort(effortList);
			System.out.println(effortuser + "新增effort" + insert);

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
		String date = "2020-02-03";
		String celldatem = date.substring(0, 4).concat(date.substring(5, 7));
		System.out.println(celldatem);
		System.out.println( Strings.isNotBlank(null));
	}

}
