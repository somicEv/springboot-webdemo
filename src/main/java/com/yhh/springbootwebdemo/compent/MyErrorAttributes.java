package com.yhh.springbootwebdemo.compent;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author: win
 * @date: 星期日
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
		Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
		Map<String, Object> ext = (Map<String, Object>)webRequest.getAttribute("ext", 0);
		errorAttributes.put("ext", ext);
		System.out.println(errorAttributes);
		return errorAttributes;
	}
}
