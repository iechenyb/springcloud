package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 
 * 1 执行登录  http://localhost:8080/login
 * 2 根据返回的tokenset到header中，然后请求
 * 3 http://localhost:8080/employee/greeting
 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
