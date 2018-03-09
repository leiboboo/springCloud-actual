package org.service.register.autoconfig;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@Configuration
//@EnableWebMvc
public class MyWebAutoConfiguration {
	@Bean
	public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
		ServletRegistrationBean testServletBean = new ServletRegistrationBean(dispatcherServlet);
		testServletBean.getUrlMappings().clear();
		testServletBean.addUrlMappings(".html");
		testServletBean.addUrlMappings(".do");
		
		return testServletBean;
	}
	
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory(8762);
		factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
		factory.setSessionTimeout(120, TimeUnit.MINUTES);
		
		return factory;
	}
}
