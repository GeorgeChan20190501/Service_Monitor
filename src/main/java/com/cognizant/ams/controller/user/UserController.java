package com.cognizant.ams.controller.user;

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
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONArray;
import com.cognizant.ams.bean.Organization;
import com.cognizant.ams.bean.SysMenu;
import com.cognizant.ams.bean.SysRole;
import com.cognizant.ams.bean.SysUser;
import com.cognizant.ams.bean.common.JsonReqObject;
import com.cognizant.ams.service.ComlistService;
import com.cognizant.ams.service.UserService;

@RestController
public class UserController {

	@Autowired
	private ComlistService comlistService;

	@Autowired
	private UserService userService;

	@GetMapping("/user.html")
	public List<Organization> initUserPage() {
		System.out.println("分公司列表初始化");
		// 获取分公司列表
		List<Organization> comlist = comlistService.getComlist();
		return comlist;
	}

	@GetMapping("/user_role.html")
	public List<SysRole> initUserRole() {
		System.out.println("用户角色初始化");
		// 获取分公司列表
		List<SysRole> rolelist = userService.getUserRole();
		return rolelist;
	}

	@PostMapping("/queryUser")
	public Map<String, Object> queryUser(@RequestBody String param) {
		System.out.println("查询用户参数===" + param);
		
		JsonReqObject jsonReqObject = JSONArray.parseObject(param, JsonReqObject.class);
		String jsonParam=jsonReqObject.getMsg();
		SysUser sysUser = JSONArray.parseObject(jsonParam, SysUser.class);
		// 查询用户
		List<SysUser> list = userService.queryUser(sysUser);
		System.out.println("总条数为===" + list.size());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		return map;
	}

	@PutMapping("/addUser")
	public String addUser(@RequestBody String param) {
		SysUser sysUser = JSONArray.parseObject(param, SysUser.class);
		List<SysUser> userlist = userService.queryUserByAccount(sysUser);
		if (userlist.size() > 0) {
			return "用户已经存在，请更换其他的账号";
		}
		System.out.println("新用户进行插入操作！");
		try {

			if (sysUser.getRoleName().equals("管理员组")) {
				sysUser.setCertifyflag("0");
				sysUser.setUsername(sysUser.getAccount() + "管理员");
				sysUser.setPassword("Hello001");
			} else {
				sysUser.setCertifyflag("1");

			}
			String baranchname = "账号";
			if (!sysUser.getBranch().equals("总公司")) {
				baranchname = "分公司账号";
			}
			sysUser.setDescribtion(sysUser.getBranch() + baranchname);
			userService.addUser(sysUser);
			return "用户添加成功!";
		} catch (Exception e) {
			return "用户添加异常";
		}
	}

	@DeleteMapping("/deleteUserMenu")
	public String deleteUserMenu(@RequestBody String param) {
		SysUser sysUser = JSONArray.parseObject(param, SysUser.class);

		System.out.println("删除用户角色！");
		try {
			String account = sysUser.getAccount();
			String rolename = sysUser.getRoleName();
			userService.deleteUserMenu(sysUser);
			return "用户" + account + "的" + rolename + "角色删除成功!";
		} catch (Exception e) {
			return "操作异常";
		}
	}

	@DeleteMapping("/deleteUser")
	public String deleteUser(@RequestBody String param) { // axios传递json串
		// {"users":["songz","caoche"]}
		System.out.println(param);
		JsonReqObject jsonReqObject = JSONArray.parseObject(param, JsonReqObject.class);
		String[] msg = jsonReqObject.getMsg().replace("\"", "").replace("[", "").replace("]", "").split(",");

		List<SysUser> userlist = new ArrayList<SysUser>();
		for (String string : msg) {
			SysUser sysUser = new SysUser();
			sysUser.setAccount(string);
			userlist.add(sysUser);
		}
		System.out.println("删除用户！");

		try {
			userService.deleteUser(userlist);
			return "删除成功!";
		} catch (Exception e) {
			return "操作异常";
		}
	}

	@PutMapping("/grantUser")
	public String grantUser(@RequestBody String param) { // axios传递json串
		// {"msg":["songz","caoche"],key:普通用户}
		System.out.println("授权====" + param);
		JsonReqObject jsonReqObject = JSONArray.parseObject(param, JsonReqObject.class);
		String[] msg = jsonReqObject.getMsg().replace("\"", "").replace("[", "").replace("]", "").split(",");
		String rolename = jsonReqObject.getMsg1();
		List<SysUser> userlist = new ArrayList<SysUser>();
		for (String string : msg) {
			SysUser sysUser = new SysUser();
			sysUser.setAccount(string);
			sysUser.setRoleName(rolename);
			userlist.add(sysUser);
		}
		System.out.println("授权用户！");

		try {
			userService.grantUser(userlist);
			return "授权成功!";
		} catch (Exception e) {
			e.printStackTrace();
			return "操作异常";
		}
	}

	@PostMapping("/updateUser")
	public String updateUser(@RequestBody String param) { // axios传递json串
		// {"msg":["songz","caoche"],key:普通用户}
		JsonReqObject jsonReqObject = JSONArray.parseObject(param, JsonReqObject.class);
		String[] msg = jsonReqObject.getMsg().replace("\\", "").replace("}\",", "}\";").replace("[\"", "").replace("\"]", "").split("\";\"");
		List<SysUser> userlist=new ArrayList<SysUser>();
		for(String string:msg)
		{
			System.out.println(string);
			SysUser sysUser = JSONArray.parseObject(string, SysUser.class);
			userlist.add(sysUser);
		}
		System.out.println("修改用户！");
		try
		{
			userService.updateUser(userlist);
			return "修改成功!";
		}catch(
		Exception e)
		{
			e.printStackTrace();
			return "操作异常";
		}
}

}
