package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
//http://blog.csdn.net/forezp/article/details/70188595
//consul agent -dev
public class SprigcloudconsulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprigcloudconsulApplication.class, args);
	}
}
