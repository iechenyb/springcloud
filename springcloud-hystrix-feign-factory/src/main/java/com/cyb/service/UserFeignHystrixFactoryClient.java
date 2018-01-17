package com.cyb.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * 
 * @author DHUser
 *  从service层通过http调用服务
 */
@FeignClient(name="SERVICE-B",fallback =HystrixClientFallback.class/*,fallbackFactory=HystrixClientFallbackFactory.class*/)
public interface UserFeignHystrixFactoryClient {
	
  @RequestMapping("/add")
  public String add(@RequestParam("a") Integer a,@RequestParam("b") Integer b);
  @RequestMapping("/div")
  public String div(@RequestParam("a") Integer a,@RequestParam("b") Integer b);

}