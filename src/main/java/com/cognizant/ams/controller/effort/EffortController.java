package com.cognizant.ams.controller.effort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.mchange.v2.lang.StringUtils;

@RequestMapping("/efforts")
@RestController
public class EffortController {

	@Autowired
	private EffortService effortService;


	@PutMapping("/save")
	public int saveEfforts(@RequestBody String effortJson) {
		System.out.println("开始保存effort===" + effortJson);

		JSONObject json = JSON.parseObject(effortJson);
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
		effort.setUsername(json.getString("userid"));

		effort.setUserid("likev");
		effort.setUsername("Kevin");

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
	public Map<String, Object> queryEffortByUser(String startworkdy, String endworkday, String usercode) {
		Map<String, Object> map = new HashMap<String, Object>();

		// TODO session 获取
		usercode = "likev";
		if (!StringUtils.nonEmptyString(usercode) || usercode.equals("ams")) {
			// 获取团队Efforts
		} else {
			// 获取个人Effort
			System.out.println(usercode + "查询用户所有effort");
			   List<SmEfforts> effortList=  effortService.queryEffortsByUser(usercode);	   
				map.put("list", effortList);
		}
		return map;
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

}
