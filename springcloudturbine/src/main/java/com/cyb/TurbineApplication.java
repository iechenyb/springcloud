package com.cyb;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
//http://blog.didispace.com/spring-cloud-tips-4/ 配置context如何使用
@SpringBootApplication
@EnableTurbine
public class TurbineApplication {
  public static void main(String[] args) {
    new SpringApplicationBuilder(TurbineApplication.class).web(true).run(args);
  }
}