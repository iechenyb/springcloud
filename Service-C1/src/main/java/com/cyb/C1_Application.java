package com.cyb;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class C1_Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(C1_Application.class).web(true).run(args);
	}

}
