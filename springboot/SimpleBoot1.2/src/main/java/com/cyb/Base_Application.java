package com.cyb;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.cyb.web.service.Sender;

@SpringBootApplication
public class Base_Application {
	public static void main(String[] args) {
		//配置文件优先级高于代码启动配置
		new SpringApplicationBuilder()
		.sources(Base_Application.class)
		.properties("server.port=8081")
		.profiles("dev").run(args);
	}
	@Autowired
	private Sender sendMessage;
	// 被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器调用一次
	@PostConstruct//PreConstruct
    public void init(){
        sendMessage.send();// 会根据profile指定的环境实例化对应的类
    }
}
