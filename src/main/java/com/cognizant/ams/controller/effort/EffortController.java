package com.cognizant.ams.controller.effort;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cognizant.ams.bean.SmConfig;
import com.cognizant.ams.bean.SmEfforts;
import com.cognizant.ams.bean.common.JsonReqObject;
import com.cognizant.ams.service.EffortService;

@RequestMapping("/efforts")
@RestController
public class EffortController {

	@Autowired
	private EffortService effortService;

	private static String loginUsercode;

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
		SmConfig temp = effortService.queryAppConfigbyEaicode(effort.getEaiCode());

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
		System.out.println("@@@传入JSON"+param);
		String usercode="";
		String startworkdy="";
		String endworkday="";
		JsonReqObject jsonReqObject = JSONArray.parseObject(param, JsonReqObject.class);
		String jsonParam = jsonReqObject.getMsg();
		if (Strings.isEmpty(jsonParam)) {
			JSONObject object=JSONObject.parseObject(param);
			 usercode=object.getString("usercode");
			 startworkdy=object.getString("startworkday");
			 endworkday=object.getString("endworkday");
		}else {
			JSONObject object=JSONObject.parseObject(jsonParam);
			usercode=object.getString("usercode");
			 startworkdy=object.getString("startworkday");
			 endworkday=object.getString("endworkday");
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		// 页面加载时查询
		System.out.println("#########EFFORT查询：usercode==="+usercode+"startworkdy==="+startworkdy+"endworkday==="+endworkday);
		if (Strings.isEmpty(usercode)) {//传入usercode为空
			
			if (!loginUsercode.equals("SYSTEM")) {// 普通用户
				List<SmEfforts> effortList = effortService.queryEffortsByUser(loginUsercode);
				map.put("list", effortList);
				return map;
			} else {// admin用户
				List<SmEfforts> effortList = effortService.queryAllEfforts();
				map.put("list", effortList);
				return map;
			}

		} else {//传入usercode为不为空（页面查询）
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

}
