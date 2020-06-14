package com.yhh.springbootwebdemo.controller;

import com.yhh.springbootwebdemo.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: win
 * @date: 星期日
 */
@ControllerAdvice
public class MyExceptionHandler {

	/*@ResponseBody
	@ExceptionHandler(UserNotExistException.class)
	public Map<String, Object> handlerException() {
		Map<String, Object> map = new HashMap<>();
		map.put("code", "E00001");
		map.put("message", "用户不存在");
		return map;
	}*/

	@ExceptionHandler(UserNotExistException.class)
	public String handlerException(Exception e, HttpServletRequest request){
		request.setAttribute("javax.servlet.error.status_code",400);
		Map<String, Object> map = new HashMap<>();
		map.put("code", "E00001");
		map.put("message", "用户不存在");
		request.setAttribute("ext",map);
		return "forward:/error";
	}

}
