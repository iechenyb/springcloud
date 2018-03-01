package com.cyb;

import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 运行启动参数为 8080 dev
 * @author DHUser
 *
 */
public class Base_Application2 {
	public static void main(String[] args) {
		//配置文件优先级高于代码启动配置
		new SpringApplicationBuilder()
		.sources(Base_Application2.class)
		.properties("server.port="+args[0])
		.profiles(args[1]).run(args);
	}
}
