package com.yhh.springbootwebdemo.config;

import com.yhh.springbootwebdemo.servlet.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: win
 * @date: 星期日
 *
 * 配置嵌入式web容器
 *
 */
@Configuration
public class MyServerConfig {

	/**
	 * 注册Servlet
	 * @return
	 */
	@Bean
	public ServletRegistrationBean myServlet() {
		ServletRegistrationBean<MyServlet> registrationBean = new ServletRegistrationBean<>(new MyServlet(), "/myServlet");
		return registrationBean;
	}

	/**
	 * Spring Boot2.0以上版本EmbeddedServletContainerCustomizer被WebServerFactoryCustomizer替代
	 * @return
	 */
	@Bean
	public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
		return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
			@Override
			public void customize(ConfigurableWebServerFactory factory) {
				factory.setPort(8083);
			}
		};
	}

}
