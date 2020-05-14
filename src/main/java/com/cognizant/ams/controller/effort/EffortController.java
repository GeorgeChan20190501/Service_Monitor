package com.cognizant.ams.controller.effort;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.ams.service.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cognizant.ams.bean.SmApplist;
import com.cognizant.ams.bean.SmConfig;
import com.cognizant.ams.bean.SmEfforts;

import com.cognizant.ams.service.EffortService;

@RequestMapping("/efforts")
@RestController
public class EffortController {
	
	@Autowired
	private EffortService effortService; 
	
	@Autowired
	private AppConfigService appConfigService;
	
	@PostMapping("/save")
	public int  saveEfforts(@RequestBody String effortJson) {
		System.out.println("开始保存effort===" + effortJson);

			JSONObject json=JSON.parseObject(effortJson);
			SmEfforts effort=new SmEfforts();
			effort.setWorkday(json.getString("workday"));
			effort.setEaiCode(json.getString("eaicode"));
			effort.setTasktype(json.getString("tasktype"));
			effort.setTicketNumber(json.getString("ticketnumber"));
			effort.setEffortsHours(json.getString("efforthours"));	
			effort.setUserid(json.getString("userid"));
			int result= effortService.save(effort);
			
			return result;
	}
	
/**
 * 
 * @return
 */
	@GetMapping("/applist")
	public  List<SmConfig> getAppList() {
	List<SmConfig> applists=	 effortService.queryAppConfig();
	return applists;
	}
	
	
	
	
	
}
