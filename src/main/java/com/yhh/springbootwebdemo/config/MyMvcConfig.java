package com.yhh.springbootwebdemo.config;

import com.yhh.springbootwebdemo.compent.LoginHandlerInterceptor;
import com.yhh.springbootwebdemo.compent.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: yuhaohan
 * @date: 星期一
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("login");
		registry.addViewController("/index").setViewName("login");
		registry.addViewController("/main").setViewName("dashboard");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 注册拦截器，并设置拦截当前项目下所有请求，并设置部分请求不被拦截
		registry.addInterceptor(new LoginHandlerInterceptor())
				.addPathPatterns("/**")
				.excludePathPatterns("/index", "/user/login", "/", "/static/**");
	}

	@Bean
	public LocaleResolver localeResolver() {
		// 设置国际化处理器
		return new MyLocalResolver();
	}

}
