package org.service.client.feign;

import org.service.client.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.service.client.feign.UserFeignHystrixClient.HystrixClientFallback;

/**
 * 使用@FeignClient注解的fallback属性，指定fallback类
 * @author Administrator
 *
 */
@FeignClient(name="microservice-provider-user", fallback=HystrixClientFallback.class)
public interface UserFeignHystrixClient {
	@RequestMapping("/{id}")
	public User findByIdFeign(@RequestParam("id") Long id);
	
	@Component
	static class HystrixClientFallback implements UserFeignHystrixClient{
		private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallback.class);
		
		@Override
		public User findByIdFeign(Long id) {
			HystrixClientFallback.LOGGER.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
			User user = new User();
	        user.setId(-1L);
	        user.setUsername("default username");
	        user.setAge(0);
	        
			return user;
		}
		
	}
}
