package org.service.register.autoconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HelloProperties.class)
@ConditionalOnClass(HelloService.class)
public class HelloAutoConfiguration {
	@Autowired
	private HelloProperties helloProperties;
	
	@Bean
	@ConditionalOnMissingBean(HelloService.class)
	public HelloService helloService() {
		HelloService helloService = new HelloService();
		helloService.setMsg(helloProperties.getMsg());
		
		return helloService;
	}
}
