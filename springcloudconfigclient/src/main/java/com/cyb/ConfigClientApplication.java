package com.cyb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

/**
 * @author Administrator
 *http://blog.csdn.net/gongxsh00/article/details/51292200\
 *启动注意事项 -Dspring.profiles.active=test   test为文件后缀名，
 *bootstrap.yml 中的spring:application:name=cyb,最终加载的文件为git/cyb-test.yml
 * http://localhost:7776/my-client/master
 *从git刷新配置信息 http://localhost:7777/refresh  仅仅支持post请求！
 */
@SpringBootApplication
public class ConfigClientApplication  {
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
		//new SpringApplicationBuilder(ConfigClientApplication.class).web(true).profiles("test").run(args);
	}

	@Autowired
	void setEnvironment(Environment env) {
		System.out.println("param from env: " + env.getProperty("from"));
	}
}