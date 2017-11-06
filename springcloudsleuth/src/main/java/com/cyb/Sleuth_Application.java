package com.cyb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;
//https://yq.aliyun.com/articles/78128?utm_campaign=wenzhang&utm_medium=article&utm_source=QQ-qun&201758&utm_content=m_19862
@SpringBootApplication
@EnableZipkinServer
public class Sleuth_Application {

    public static void main(String[] args) {
        SpringApplication.run(Sleuth_Application.class, args);
    }
}