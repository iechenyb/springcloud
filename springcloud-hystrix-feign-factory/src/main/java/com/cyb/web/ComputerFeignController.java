package com.cyb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyb.service.SerivceAComputerFeignClient;
import com.cyb.service.UserFeignHystrixFactoryClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/**
 * 类似dubbo的使用
 * implements TestFeignClient
 */
@RestController
public class ComputerFeignController{
	/*@SuppressWarnings("unused")
	@Autowired
	private RestTemplate restTemplate;*/
	
	@Autowired
	private UserFeignHystrixFactoryClient testFeignClient;

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"))
	@RequestMapping("comAdd")
	public String add(Integer a,Integer b) {
		System.out.println(a / b);
		String string = this.testFeignClient.add(a, b);
		return string;
	}
	/**
	 * 
	 *作者 : iechenyb<br>
	 *方法描述: 远端出现异常时，调用factory的回调类！
	 *同时创建工程处理和熔断命令，则优先执行工厂处理，且不计入仪表盘！<br>
	 *创建时间: 2017年7月15日
	 *@param a
	 *@param b
	 *@return
	 */
	@RequestMapping("comDiv")
	@HystrixCommand(fallbackMethod="fallback",commandProperties = @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"))
	public String div(Integer a,Integer b) {
		String string = this.testFeignClient.div(a, b);
		return string;
	}
	//服务宕机或者不可用时，即请求超时后会调用此方法
	public String fallback(Integer a, Integer b) {
		return "异常发生，进入fallback方法，接收的参数：a = {} ,b={}";
	}
	public String fallback(Long a, Long b) {
		return "异常发生，进入fallback方法，接收的参数：a = {} ,b={}";
	}
	
	@Autowired
	SerivceAComputerFeignClient serviceA;
	
	@RequestMapping("saadd")
	@HystrixCommand(fallbackMethod = "fallback")
	public String saAdd(Integer a, Integer b){
		return serviceA.add(a, b);
	}
	
	@RequestMapping("sadiv")
	@HystrixCommand(fallbackMethod = "fallback")
	public String saDiv(Long a,Long b){
		return serviceA.div(a, b).toString();
	}
}