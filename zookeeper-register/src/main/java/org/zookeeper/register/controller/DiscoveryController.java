package org.zookeeper.register.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscoveryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DiscoveryController.class);
	@Autowired
    private LoadBalancerClient loadBalancer;
    @Autowired
    private DiscoveryClient discovery;
	
    @GetMapping("/readDiscovery")
	public String readDiscovery() {
		List<String> serviceList = discovery.getServices();
		
		return Arrays.toString(serviceList.toArray(new String[] {}));
	}
}
