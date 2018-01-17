package com.cyb.service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
/**
 *作者 : iechenyb<br>
 *类描述: 说点啥<br>
 *创建时间: 2018年1月17日
 */
@Component
public class HystrixClientFallback  implements UserFeignHystrixFactoryClient {
	Log log = LogFactory.getLog(HystrixClientFallback.class);
	
	public String add(Integer a, Integer b) {
		return "执行add异常啦！";
	}

	public String div(Integer a, Integer b) {
		return "执行div异常啦！";
	}
}
