package com.cyb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
/*  微服务集成 Hystrix 断路器实现失败快速响应，达到熔断效果：
	注解：EnableCircuitBreaker、HystrixCommand 的编写；
	https://gitee.com/ylimhhmily/SpringCloudTutorial
*/
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
//enable @HystrixCommand ，服务降级可以与factory并存！
@EnableCircuitBreaker 
@EnableHystrix
public class FeignHystrixApplication {
  public static void main(String[] args) {
    SpringApplication.run(FeignHystrixApplication.class, args);
  }
}