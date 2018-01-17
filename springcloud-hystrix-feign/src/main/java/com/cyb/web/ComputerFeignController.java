package com.cyb.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyb.api.ControllerAware;
import com.cyb.service.ComputerFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 类似dubbo的使用
 * implements TestFeignClient
 */
@RestController
public class ComputerFeignController implements ControllerAware{
	
	@Autowired
	private ComputerFeignService testFeignClient;

	@HystrixCommand(fallbackMethod = "fallback")
	@RequestMapping("comAdd")
	public String add(Integer a,Integer b) {
		System.out.println(a / b);
		String string = this.testFeignClient.add(a, b);
		return string;
	}
	
	public String fallback(Integer a, Integer b) {
		return "异常发生，进入fallback方法，接收的参数：a = {} ,b={}";
	}
	
	@RequestMapping("comSub")
	public Long sub(Long a, Long b) {
		return this.testFeignClient.sub(a, b);
	}
	
	@RequestMapping("comDiv")
	public Long div(Long a, Long b) {
		return this.testFeignClient.div(a, b);
	}
	
	@RequestMapping("comMulti")
	public Long multi(Long a, Long b) {
		return this.testFeignClient.multi(a, b);
	}
	
	@HystrixCommand(fallbackMethod = "fallback1")
	@RequestMapping("comJson")
	public String object(@RequestBody User user) {
		String str =  this.testFeignClient.object(user);
		System.out.println(str+"----- feigin user is "+user.getName()+","+user.getAge());
		return str;
	}
	
	public String fallback1(User user) {
		return "异常发生，进入fallback方法，接收的参数：name = {} ,age={}";
	}
	@HystrixCommand(fallbackMethod = "fallback1")
	@RequestMapping("comUser/{name}")
	public User retUser(@PathVariable(value="name") String name) {
		System.out.println("查询名称为："+name);
		return this.testFeignClient.retUser(name);
	}
	
	@RequestMapping("comMap")
	public Map<String, Object> retMap() {
		return testFeignClient.retMap();
	}
	
	@RequestMapping("comList")
	public List<Object> retList() {
		return testFeignClient.retList();
	}
	//继承接口方法，可以用
	public String fadd(Integer a, Integer b) {
		return a+b+"!";
	}
	/**
	 * 继承接口方法，参数上的注解必须带上，否则不能用，
	 * 请求路径都写在了接口的申明上！
	 */
	public User faddPath(@PathVariable("a")Integer a, @PathVariable("b")Integer b) {
		User user = new User();
		user.setAge(a+b);
		user.setName("sdfsdfsdfsf");
		return user;
	}
}