package com.cyb.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyb.api.ControllerAware;
import com.cyb.service.UserFeignHystrixFactoryClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 类似dubbo的使用
 * implements TestFeignClient
 */
@RestController
public class ComputerFeignController{
	
	@Autowired
	private UserFeignHystrixFactoryClient testFeignClient;

	@HystrixCommand(fallbackMethod = "fallback")
	@RequestMapping("comAdd")
	public String add(Integer a,Integer b) {
		System.out.println(a / b);
		String string = this.testFeignClient.add(a, b);
		return string;
	}
	/**
	 * 
	 *作者 : iechenyb<br>
	 *方法描述: 远端出现异常时，调用factory的回调类！<br>
	 *创建时间: 2017年7月15日
	 *@param a
	 *@param b
	 *@return
	 */
	@RequestMapping("comDiv")
	public String div(Integer a,Integer b) {
		String string = this.testFeignClient.div(a, b);
		return string;
	}
	
	
	public String fallback(Integer a, Integer b) {
		return "异常发生，进入fallback方法，接收的参数：a = {} ,b={}";
	}
	
}