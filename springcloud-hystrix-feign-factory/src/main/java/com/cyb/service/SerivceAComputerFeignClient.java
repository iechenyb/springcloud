package com.cyb.service;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyb.web.User;

/**
 * 定义远端服务接口
 * 
 * @author DHUser
 *
 */
@FeignClient(name = "SERVICE-A")
public interface SerivceAComputerFeignClient {

	@RequestMapping("/add")
	// @HystrixCommand(fallbackMethod = "fallback") 只能出现在实现类上
	public String add(@RequestParam("a") Integer a, @RequestParam("b") Integer b);

	@RequestMapping("/sub")
	public Long sub(@RequestParam("a") Long a, @RequestParam("b") Long b);

	@RequestMapping("/div")
	public Long div(@RequestParam("a") Long a, @RequestParam("b") Long b);

	@RequestMapping("/multi")
	public Long multi(@RequestParam("a") Long a, @RequestParam("b") Long b);

	// ,consumes="application/json"@RequestBody
	// 返回字符串
	@RequestMapping(value = "/object", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String object(@RequestBody User user);

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
	public String user(@ModelAttribute("user") User user);

	// 返回对象测试
	@RequestMapping(value = "/retUser/{name}",
	// produces = MediaType.APPLICATION_JSON_VALUE,
	method = RequestMethod.GET)
	@ResponseBody
	public User retUser(@PathVariable(value = "name") String name);

	// 返回对象测试
	@RequestMapping(value = "/retMap", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> retMap();

	// 返回对象测试
	@RequestMapping(value = "/retList", method = RequestMethod.GET)
	@ResponseBody
	public List<Object> retList();

}