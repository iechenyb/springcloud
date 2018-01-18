package com.cyb;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrix
//@EnableHystrixDashboard
public class B2_Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(B2_Application.class).web(true).run(args);
	}

}
