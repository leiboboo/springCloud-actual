package org.zookeeper.register.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.ServiceInstanceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ServiceRegister implements ApplicationRunner {
	@Value("${zookeeper.address}")
	private String zkAddress;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		CuratorFramework client = CuratorFrameworkFactory.newClient(zkAddress, new ExponentialBackoffRetry(1000, 3));
		client.start();
		client.blockUntilConnected();
		
		ServiceInstance<Object> isntance = ServiceInstance.builder().name("service").address("127.0.0.1").port(8081).build();
		ServiceDiscovery<Object> discovery = ServiceDiscoveryBuilder.builder(Object.class).client(client).basePath("/soa").build();
		
		discovery.registerService(isntance);
		discovery.start();
	}

}
