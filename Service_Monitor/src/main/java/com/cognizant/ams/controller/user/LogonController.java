package com.cognizant.ams.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.ams.bean.SysMenu;
import com.cognizant.ams.service.LogonService;
import com.cognizant.ams.service.MenuService;


@Controller
public class LogonController {

	@Autowired
	private LogonService logonService;	
	@Autowired
	private MenuService menuService;
	
	@PostMapping("/logon")
	@ResponseBody
	public String logon(String username,String password,HttpServletRequest request) {
		System.out.println("开始验证登录，username="+username+"====password="+password);
		boolean flag =logonService.checkUser(username, password);
		if (flag) {
			HttpSession session =request.getSession(true);
			session.setAttribute("username", username);
		}
		System.out.println("验证登录flag="+flag);
		return flag+"";
	}
	
	@GetMapping("/index.html")
	public ModelAndView logon(HttpServletRequest request) {			
			HttpSession session =request.getSession(true);
			String username =(String) session.getAttribute("username");
			if (username==null||username.equals("")) {
				System.out.println("session过期，需要重新登陆。");
				return new ModelAndView("redirect:/logon.html");
			}
			System.out.println("验证通过,开始拉取用户菜单");
 
			    List<SysMenu> list =menuService.getUserMenu(username);
				ModelAndView modelAndView=new ModelAndView("index");
				modelAndView.addObject("username", username);
				modelAndView.addObject("menus", list);
				return  modelAndView;	
			 
		 
	}
}
