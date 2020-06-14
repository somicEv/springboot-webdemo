package com.yhh.springbootwebdemo.config;

import com.yhh.springbootwebdemo.compent.LoginHandlerInterceptor;
import com.yhh.springbootwebdemo.compent.MyLocalResolver;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
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
		// 静态资源不用进行配置，SpringBoot已经配置了静态资源映射
		registry.addInterceptor(new LoginHandlerInterceptor())
				.addPathPatterns("/**")
				.excludePathPatterns("/index", "/user/login", "/", "/static/**");
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new MyLocalResolver();
	}

}
