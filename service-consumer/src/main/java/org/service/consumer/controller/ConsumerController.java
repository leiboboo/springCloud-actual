package org.service.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/add")
	public String add() {
		return restTemplate.getForEntity("http://SERVICE-CLIENT/add?a=10&b=20", String.class).getBody();
	}
}
