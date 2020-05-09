package com.cognizant.ams.controller.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONArray;
import com.cognizant.ams.bean.SysMenu;
import com.cognizant.ams.bean.common.JsonReqObject;
import com.cognizant.ams.common.PageHelper;
import com.cognizant.ams.service.MenuService;

@RestController
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	
	@PostMapping("/queryMenu")
	public List<SysMenu> queryMenu(@RequestBody String param) {
		System.out.println("查询菜单参数===" + param);
		JsonReqObject jsonReqObject = JSONArray.parseObject(param, JsonReqObject.class);
		String jsonParam=jsonReqObject.getMsg();
		System.out.println(jsonParam);
		SysMenu sysMenu = JSONArray.parseObject(jsonParam, SysMenu.class);
		// 查询菜单
		List<SysMenu> menulist = menuService.queryMenu(sysMenu);
		System.out.println("查询菜单个数===" + menulist.size());
		return menulist;
	}
	
	@PutMapping("/addMenu")
	public String addMenu(@RequestBody String param) {
		System.out.println("查询菜单参数===" + param);
		JsonReqObject jsonReqObject = JSONArray.parseObject(param, JsonReqObject.class);
		String jsonParam=jsonReqObject.getMsg();
		System.out.println(jsonParam);
		SysMenu sysMenu = JSONArray.parseObject(jsonParam, SysMenu.class);
		// 查询菜单
		try {
			menuService.addMenu(sysMenu);
		} catch (Exception e) {
			return "操作异常";
		}
		return "菜单添加成功";
	}
	
	@DeleteMapping("/deleteMenu")
	public String deleteMenu(@RequestBody String param) {
		System.out.println("删除菜单参数===" + param);
		JsonReqObject jsonReqObject = JSONArray.parseObject(param, JsonReqObject.class);
		String jsonParam=jsonReqObject.getMsg();   //字符数组
		System.out.println(jsonParam);
		String ids [] =jsonParam.replace("[", "").replace("]", "").split(",");
		List<String> list = new ArrayList<String>();
		for (String id : ids) {
			list.add(id);
		}
		// 查询菜单
		System.out.println(list);
		try {
			menuService.deleteMenu(list);
		} catch (Exception e) {
			return "操作异常";
		}
		return "菜单删除成功";
	}
	
	@PostMapping("/updateMenu")
	public String updateMenu(@RequestBody String param) {
		JsonReqObject jsonReqObject = JSONArray.parseObject(param, JsonReqObject.class);
		String jsonParam=jsonReqObject.getMsg();   //对象形式字符数组
 		System.out.println("修改菜单参数===" +jsonParam);
		String menus [] =jsonReqObject.getMsg().replace("\\", "").replace("}\",", "}\";").replace("[\"", "").replace("\"]", "").split("\";\"");
		List<SysMenu> list = new ArrayList<SysMenu>();
		SysMenu sysMenu ;
		for (String menu : menus) {
			sysMenu= JSONArray.parseObject(menu, SysMenu.class);
			list.add(sysMenu);
		}
		try {
			menuService.updateMenu(list);
		} catch (Exception e) {
			return "操作异常";
		}
		return "菜单更新成功";
	}


	@SuppressWarnings("unchecked")
	@PostMapping("/fenyeQueryMenu")
	public Map<String, Object> fenyeQueryMenu(@RequestBody String param) {
		System.out.println("分页查询参数===" + param);
		JsonReqObject jsonReqObject = JSONArray.parseObject(param, JsonReqObject.class);
		String jsonParam=jsonReqObject.getMsg();
		String currentPage=jsonReqObject.getMsg1();
		String pageSize=jsonReqObject.getMsg2();
		System.out.println(currentPage);
		System.out.println("当前页为："+currentPage+"，当前页面大小："+pageSize);
		SysMenu sysMenu = JSONArray.parseObject(jsonParam, SysMenu.class);
		// 查询菜单
		List<SysMenu> menulist = menuService.queryMenu(sysMenu);
		
		//上述拿到完整list，现在进行分页返回当前页面数据。
		System.out.println("总条数为===" + menulist.size());
		List<SysMenu> fenyemenulist =PageHelper.getDataByFenye(menulist, currentPage, pageSize);
		Map<String, Object> map =new HashMap<String, Object>();
		int pageTotal=menulist.size()/Integer.parseInt(pageSize);
		if (menulist.size()%Integer.parseInt(pageSize)!=0) {
			pageTotal++;
		}
		map.put("fenyeMenus", fenyemenulist);
		map.put("pageTotal",  pageTotal);
		return map;
	}
	
	
	

}
