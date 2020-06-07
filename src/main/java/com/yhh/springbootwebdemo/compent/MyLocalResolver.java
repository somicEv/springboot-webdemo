package com.yhh.springbootwebdemo.compent;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author: yuhaohan
 * @date: 星期三
 */
public class MyLocalResolver implements LocaleResolver {

	@Override
	public Locale resolveLocale(HttpServletRequest httpServletRequest) {
		String l = httpServletRequest.getParameter("l");
		Locale locale = Locale.getDefault();
		if (!StringUtils.isEmpty(l)) {
			String[] array = l.split("_");
			locale = new Locale(array[0], array[1]);
		}
		return locale;
	}

	@Override
	public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

	}
}
