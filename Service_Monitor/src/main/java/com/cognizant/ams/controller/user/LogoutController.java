package com.cognizant.ams.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session =request.getSession(true);
		String username =(String) session.getAttribute("username");
		if (username!=null) {
			if (!username.equals("")) {
				session.removeAttribute("username");
				System.out.println("session已经销毁，返回登陆页");
			}
		}
		return new ModelAndView("redirect:/logon.html");
	}
}
