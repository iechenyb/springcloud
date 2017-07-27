package com.cyb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
 * http://localhost:7776/param
 * springcloud Could not resolve placeholder 'from' in string value "${from}"
 * 解决方案，请看启动类
 */
@RestController
@RefreshScope
public class ParameterRestController {
	@Autowired
	ELConfig elConfig;
	
	@Autowired
	AuthorSettings setting;
	
	@Value("${from}")
	private String from;
	
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
