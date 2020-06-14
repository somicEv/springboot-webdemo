package com.yhh.springbootwebdemo.exception;

/**
 * @author: win
 * @date: 星期日
 */
public class UserNotExistException extends RuntimeException{

	public UserNotExistException() {
		super("用户不存在");
	}
}
