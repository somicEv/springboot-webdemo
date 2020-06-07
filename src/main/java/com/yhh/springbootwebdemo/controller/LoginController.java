package com.yhh.springbootwebdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author: yuhaohan
 * @date: 星期五
 */
@Controller
public class LoginController {

	@PostMapping(value = "/user/login")
	public String login(@RequestParam("username") String username,
						@RequestParam("password") String password, HttpSession session) {
		if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
			session.setAttribute("loginUser", username);
			// 防止表单重复提交，重定向到成功页面
			return "redirect:/main";
		} else {
			return "login";
		}
	}

}
