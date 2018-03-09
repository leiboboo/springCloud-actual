package org.service.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaServer
@EnableHystrixDashboard
public class EurekaServiceRegisterApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(EurekaServiceRegisterApplication.class, args);
    }
}
