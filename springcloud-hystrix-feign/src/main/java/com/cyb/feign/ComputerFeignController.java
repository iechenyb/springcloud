package com.cyb.feign;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cyb.web.User;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 类似dubbo的使用
 * implements TestFeignClient
 */
@RestController
public class ComputerFeignController  implements ServiceBComputerFeignClient{
	
	@Autowired
	private ServiceBComputerFeignClient testFeignClient;

	//@RequestMapping(value = "/add" , method = RequestMethod.GET) 写到接口上即可
	@HystrixCommand(fallbackMethod = "fallback")
	public String add(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
		System.out.println(a / b);// 当b=0的时候，程序报错，直接回调fallback方法，进行熔断。
		String string = this.testFeignClient.add(a, b);
		return string;
	}
	/**
	 * hystrix fallback方法
	 */
	public String fallback(Integer a, Integer b) {
		return "异常发生，进入fallback方法，接收的参数：a = {} ,b={}";
	}
	/**
	 * 
	 *作者 : iechenyb<br>
	 *方法描述: 回调函数的参数列表及返回值
	 *必须与发生回调的方法一致！<br>
	 *创建时间: 2017年7月15日
	 *@param a
	 *@param b
	 *@return
	 */
	public Long fallback2(Long a, Long b) {
		return 0l;//当除法出现异常时 比如1/0时，返回0L
	}

	public Long sub(Long a, Long b) {
		return this.testFeignClient.sub(a, b);
	}
	@HystrixCommand(fallbackMethod = "fallback2")
	public Long div(Long a, Long b) {
		return this.testFeignClient.div(a, b);
	}

	public Long multi(Long a, Long b) {
		return this.testFeignClient.multi(a, b);
	}
	@HystrixCommand(fallbackMethod = "fallback1")
	public String object(@RequestBody User user) {
		String str =  this.testFeignClient.object(user);
		System.out.println(str+"----- feigin user is "+user.getName()+","+user.getAge());
		return str;
	}
	public String fallback1(User user) {
		return "异常发生，进入fallback方法，接收的参数：name = {} ,age={}";
	}
	public User retUser(@PathVariable(value="name") String name) {
		System.out.println("查询名称为："+name);
		return this.testFeignClient.retUser(name);
	}
	public Map<String, Object> retMap() {
		return testFeignClient.retMap();
	}
	public List<Object> retList() {
		return testFeignClient.retList();
	}
	public String user(User user) {
		String str = testFeignClient.user(user);
		System.out.println(str+"----- feigin user is "+user.getName()+","+user.getAge());
		return str;
	}
	public String fadd(Integer a, Integer b) {
		return null;
	}
	public User faddPath(Integer a, Integer b) {
		return null;
	}
	
	
	//****************************Service-A调用
	@Autowired
	SerivceAComputerFeignClient serviceA;
	
	@RequestMapping("saadd")
	@HystrixCommand(fallbackMethod = "fallback")
	public String saAdd(Integer a, Integer b){
		return serviceA.add(a, b);
	}
	
	@RequestMapping("sadiv")
	@HystrixCommand(fallbackMethod = "fallback2")
	public String saDiv(Long a,Long b){
		return serviceA.div(a, b).toString();
	}
}