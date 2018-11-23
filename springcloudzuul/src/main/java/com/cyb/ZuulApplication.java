package com.cyb;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.cyb.filter.AccessFilter;

@EnableZuulProxy
@SpringCloudApplication
public class ZuulApplication {

	public static void main(String[] args) {
		//new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
		 SpringApplication.run(ZuulApplication.class, args);
	}

	/*@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}*/

}
