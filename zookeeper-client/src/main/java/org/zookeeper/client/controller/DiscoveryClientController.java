package org.zookeeper.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DiscoveryClientController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DiscoveryClientController.class);
	@Autowired
    private LoadBalancerClient loadBalancer;
    @Autowired
    private DiscoveryClient discovery;
    @Autowired
    private RestTemplate restTemplate;
	
    @GetMapping("/discovery")
	public String discovery() {
		LOGGER.info("-------"+loadBalancer.choose("ZookeeperRegister"));
		
		return restTemplate.getForEntity("http://localhost:8010/readDiscovery", String.class).getBody();
	}
}
