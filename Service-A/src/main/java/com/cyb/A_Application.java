package com.cyb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//http://127.0.0.1:8880/myendpoint
@EnableDiscoveryClient
@SpringBootApplication
public class A_Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(A_Application.class).web(true).run(args);
	}
	//http://127.0.0.1:8880/service-instances/SERVICE-A
	@RestController
	class ServiceInstanceRestController {

	    @Autowired
	    private DiscoveryClient discoveryClient;

	    @RequestMapping("/service-instances/{applicationName}")
	    public List<ServiceInstance> serviceInstancesByApplicationName(
	            @PathVariable String applicationName) {
	        return this.discoveryClient.getInstances(applicationName);
	    }

	    @RequestMapping("/")
	    public String sayhello() {
	        return "hello";
	    }
	}
}
