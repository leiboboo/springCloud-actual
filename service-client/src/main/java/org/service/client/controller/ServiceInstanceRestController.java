package org.service.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceInstanceRestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceInstanceRestController.class);
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping(value="/add")
	public String add(@RequestParam Integer num1,@RequestParam Integer num2) {
		ServiceInstance instance = discoveryClient.getLocalServiceInstance();
		Integer result = num1+num2;
		
		LOGGER.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + result);
		
		return result.toString();
	}
}
