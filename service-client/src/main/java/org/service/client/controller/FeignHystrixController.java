package org.service.client.controller;

import org.service.client.entity.User;
import org.service.client.feign.UserFeignHystrixClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignHystrixController {
	@Autowired
	private UserFeignHystrixClient userFeignHystrixClient;
	
	@GetMapping("feign/{id}")
	public User findByIdFeign(@PathVariable Long id) {
		User user = userFeignHystrixClient.findByIdFeign(id);
		
		return user;
	}
}
