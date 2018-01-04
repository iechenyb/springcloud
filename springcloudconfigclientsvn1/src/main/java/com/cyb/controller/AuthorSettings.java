package com.cyb.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 作者 : iechenyb<br>
 * 类描述: 可以使用locations指定读取的properties文件路径, 如果不指定locations就会读取默认的properties配置文件
 * <br>
 * 创建时间: 2017年7月27日
 */
@Configuration//
//@EnableConfigurationProperties
@ConfigurationProperties(locations = "classpath:/author.properties", ignoreUnknownFields = false, prefix = "author")
public class AuthorSettings {
	Log log = LogFactory.getLog(AuthorSettings.class);
	//@NotBlank
	private String name;//
	//@NotNull
	private Long age;//

	public String getName() {
		return name;
	}

	public void setName(String name) {
		log.info("配置文件初始化：" + name);
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}
}
