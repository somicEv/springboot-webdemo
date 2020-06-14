package com.yhh.springbootwebdemo.controller;

import com.yhh.springbootwebdemo.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: yuhaohan
 * @date: 星期一
 */
@Controller
public class HelloController {

	@RequestMapping(value = "/hello")
	public String test(@RequestParam("user") String user){
		if ("aaa".equals(user)) {
			throw new UserNotExistException();
		}
		return "Hello world";
	}
}
