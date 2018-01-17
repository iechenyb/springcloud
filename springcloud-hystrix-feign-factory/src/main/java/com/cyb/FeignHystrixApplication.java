package com.cyb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
//enable @HystrixCommand ，服务降级可以与factory并存！
@EnableCircuitBreaker 
public class FeignHystrixApplication {
  public static void main(String[] args) {
    SpringApplication.run(FeignHystrixApplication.class, args);
  }
}