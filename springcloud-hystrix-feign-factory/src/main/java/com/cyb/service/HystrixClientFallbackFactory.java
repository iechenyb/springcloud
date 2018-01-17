package com.cyb.service;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.cyb.web.User;

import feign.hystrix.FallbackFactory;
/**
 *作者 : iechenyb<br>
 *类描述: 说点啥<br>
 *创建时间: 2018年1月17日
 */
@Component
public class HystrixClientFallbackFactory  implements FallbackFactory<UserFeignHystrixFactoryClient>{
	Log log = LogFactory.getLog(HystrixClientFallbackFactory.class);
	public UserFeignHystrixFactoryClient  create(Throwable arg0) {
		return new UserFeignWithFallBackFactoryClient() {
			public String add(Integer a, Integer b) {
				return "加法出错了！";
			}

			public String div(Integer a, Integer b) {
				return "除法异常啦！";
			}
		};
	}
}
