package com.cyb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.Environment;

/**
 * @author Administrator
 *http://blog.csdn.net/gongxsh00/article/details/51292200\
 *启动注意事项 -Dspring.profiles.active=test   test为文件后缀名，
 *bootstrap.yml 中的spring:application:name=cyb,最终加载的文件为git/cyb-test.yml
 * http://localhost:7776/my-client/master
 *从git刷新配置信息 http://localhost:7776/refresh  仅仅支持post请求！
 *不走消息总线的时候，需要通知各个客户端进行刷新。
 */
@SpringBootApplication
public class ConfigClientApplication  {
	public static void main(String[] args) {
		//SpringApplication.run(ConfigClientApplication.class, args);
		//spring.application.name+test.properties
		new SpringApplicationBuilder(ConfigClientApplication.class).web(true).profiles("dev").run(args);
	}
     //项目启动时，读取配置文件参数做初始化使用
	@Autowired
	void setEnvironment(Environment env) {
		System.out.println("param from env: " + env.getProperty("from"));
	}
}