package com.cyb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

/**
 * @author Administrator
 *http://blog.csdn.net/gongxsh00/article/details/51292200\
 *启动参数   vm Dspring.profiles.active=uat
 *访问：http://localhost:8888/my-client/master
 *刷新git文件http://localhost:8080/refresh
 */
@SpringBootApplication
public class ConfigClientApplication  {
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@Autowired
	void setEnvironment(Environment env) {
		System.out.println("my-config.appName from env: " + env.getProperty("my-config.appName"));
	}
}