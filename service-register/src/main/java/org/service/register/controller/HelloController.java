package org.service.register.controller;

import org.service.register.autoconfig.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Autowired
	private HelloService helloService;
	
	@RequestMapping(value="/auto/home")
	public String home() {
		return helloService.getMsg();
	}
}
