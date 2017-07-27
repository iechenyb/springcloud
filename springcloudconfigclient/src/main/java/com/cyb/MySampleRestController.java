package com.cyb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
 * http://localhost:8080/app-name
 */

@RestController
@RefreshScope
public class MySampleRestController {
	@Value("${my-config.appName}")
	private String appName;
	
	@RequestMapping("/app-name")
	public String getAppName() {
		return appName;
	}
}
