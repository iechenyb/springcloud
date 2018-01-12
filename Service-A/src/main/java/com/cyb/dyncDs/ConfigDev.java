package com.cyb.dyncDs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * 作者 : iechenyb<br>
 * 类描述: 说点啥<br>
 * 创建时间: 2018年1月11日
 */
@Configuration
@Profile("prod")
@PropertySource("db-dev.properties")
public class ConfigDev {

	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String password;
	@Value("${db.url}")
	private String url;
	@Value("${db.driverClass}")
	private String driverClass;

	@Bean
	public MyDatasource datasource() {
		return new MyDatasource();
	}
}
