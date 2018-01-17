package com.cyb.feign;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyb.feign.TestFeignClient.HystrixClientFallback;
import com.cyb.web.User;

//@FeignClient("SERVICE-B")
@FeignClient(name = "SERVICE-B",fallback = HystrixClientFallback.class)
public interface TestFeignClient {
	
  @RequestMapping("/add")
  //@HystrixCommand(fallbackMethod = "fallback") 只能出现在实现类上
  public String add(@RequestParam("a") Integer a,@RequestParam("b") Integer b);
  @RequestMapping("/sub")
  public Long sub(@RequestParam("a") Long a,@RequestParam("b") Long b);
  @RequestMapping("/div")
  public Long div(@RequestParam("a") Long a,@RequestParam("b") Long b);
  @RequestMapping("/multi")
  public Long multi(@RequestParam("a") Long a,@RequestParam("b") Long b);
  //,consumes="application/json"@RequestBody
  //返回字符串
  @RequestMapping(value = "/object", method = RequestMethod.POST,
          produces = MediaType.APPLICATION_JSON_VALUE, 
          consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public String object(@RequestBody User user);
  
  //返回对象测试
  @RequestMapping(value = "/retUser/{name}",
		  //produces = MediaType.APPLICATION_JSON_VALUE,
		  method = RequestMethod.GET)
  @ResponseBody
  public User retUser(@PathVariable(value="name") String name);
  
  //返回对象测试
  @RequestMapping(value = "/retMap",
		  method = RequestMethod.GET)
  @ResponseBody
  public Map<String,Object> retMap();
  
  //返回对象测试
  @RequestMapping(value = "/retList",
		  method = RequestMethod.GET)
  @ResponseBody
  public List<Object> retList();
  
  @Component
  static class HystrixClientFallback implements TestFeignClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallback.class);

	public String add(Integer a, Integer b) {
		HystrixClientFallback.LOGGER.info("异常发生，进入fallback方法，接收的参数： {},{}",a,b);
		return "feign-hystrix";
	}

	public Long multi(Long a, Long b) {
		return null;
	}

	public Long sub(Long a, Long b) {
		return null;
	}

	public Long div(Long a, Long b) {
		return null;
	}

	public String object(User user) {
		return null;
	}

	public User retUser(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> retMap() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object> retList() {
		// TODO Auto-generated method stub
		return null;
	}
  }
}