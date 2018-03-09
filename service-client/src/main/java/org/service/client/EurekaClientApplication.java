package org.service.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootConfiguration
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@ComponentScan("org.service.client")
public class EurekaClientApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}
