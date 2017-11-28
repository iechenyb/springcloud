package com.cyb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
 * http://localhost:7776/git/param/from gith上获取from的属性值
 * http://localhost:7776/local/el/name 从本地获取el注入的属性值
 * http://localhost:7776/local/fel/name 从本地获取非el注入的属性值（没调试通）
 * springcloud Could not resolve placeholder 'from' in string value "${from}"
 * 解决方案，请看启动类
 */
@RestController
@RefreshScope// 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
public class ParameterRestController {
	
	@Autowired
	ELConfig elConfig;
	
	@Autowired
	AuthorSettings setting;
	
	//git
	@Value("${from}")
	private String from;
	
	//从git上读取from的属性值
	@RequestMapping("/git/param/from")
	public String getGitFrom() {
		return from;
	}
	
	@RequestMapping("/local/el/name")
	public String getLocal1() {
		return elConfig.getName();
	}
	
	@RequestMapping("/local/fel/name")
	public String getLocal2() {
		return setting.getName();
	}
}
