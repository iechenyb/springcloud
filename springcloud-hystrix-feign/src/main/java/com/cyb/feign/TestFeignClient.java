package com.cyb.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cyb.feign.TestFeignClient.HystrixClientFallback;


@FeignClient(name = "SERVICE-B",fallback = HystrixClientFallback.class)
public interface TestFeignClient {
	
  @RequestMapping("/add")
  public String add(@RequestParam("a") Integer a,@RequestParam("b") Integer b);

  @Component
  static class HystrixClientFallback implements TestFeignClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallback.class);

	public String add(Integer a, Integer b) {
		HystrixClientFallback.LOGGER.info("异常发生，进入fallback方法，接收的参数： {},{}",a,b);
		return "feign-hystrix";
	}
  }
}