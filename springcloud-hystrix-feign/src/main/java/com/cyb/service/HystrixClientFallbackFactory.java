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
public class HystrixClientFallbackFactory  implements FallbackFactory<ComputerFeignService>{
	Log log = LogFactory.getLog(HystrixClientFallbackFactory.class);

	public ComputerFeignService create(Throwable arg0) {
		return new ComputerFeignServiceFallBack() {
			
			public Long sub(Long a, Long b) {
				return null;
			}
			
			public User retUser(String name) {
				return null;
			}
			
			public Map<String, Object> retMap() {
				return null;
			}
			
			public List<Object> retList() {
				return null;
			}
			
			public String object(User user) {
				return null;
			}
			
			public Long multi(Long a, Long b) {
				return null;
			}
			
			public Long div(Long a, Long b) {
				return null;
			}
			
			public String add(Integer a, Integer b) {
				return "加法出错了！";
			}
		};
	}
}
