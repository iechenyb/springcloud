package com.cyb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/*
     解决方案，请看启动类
 */
@RestController
@RefreshScope
/* 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，
 * 自动将新的配置更新到该类对应的字段中。*/
public class ParamController {
	
	@Value("${from}")
	private String from;
	
	@GetMapping("getConfigFromConfigServer")
	public String getConfigFromConfigServer() {
		return from;
	}
}
