package com.cyb.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.spring.ReferenceBean;
import com.cyb.dubbo.test.EchoService;

/**
 * 作者 : iechenyb<br>
 * 类描述: 说点啥<br>
 * 创建时间: 2017年12月14日
 */
//@Configuration
public class ReferenceConfig {
	Log log = LogFactory.getLog(ReferenceConfig.class);

	//@Bean
	public ReferenceBean<EchoService> person() {
		ReferenceBean<EchoService> ref = new ReferenceBean<>();
		ref.setVersion("1.0.0");
		ref.setInterface(EchoService.class);
		ref.setTimeout(5000);
		ref.setRetries(3);
		ref.setCheck(false);
		return ref;
	}
}
