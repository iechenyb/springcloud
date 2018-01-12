package com.cyb.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.config.EnableAdminServer;
//http://blog.didispace.com/spring-boot-actuator-1/
//http://blog.csdn.net/kinginblue/article/details/52132113
//@Configuration
//@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableAdminServer
@SpringBootApplication
public class Service_AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(Service_AdminApplication.class, args);
    }
}