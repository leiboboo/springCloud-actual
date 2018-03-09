package org.service.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootConfiguration
@EnableDiscoveryClient
@EnableAutoConfiguration
@ComponentScan("org.service.consumer")
public class EurekaConsumerApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(EurekaConsumerApplication.class, args);
    }
    
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
    	return new RestTemplate();
    }
}
