package com.cyb.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
/**
 * 类似dubbo的使用
 */
@RestController
public class FeignController implements TestFeignClient{
  @Autowired
  private TestFeignClient testFeignClient;

  //@RequestMapping(value = "/add" , method = RequestMethod.GET) 写到接口上即可
  @HystrixCommand(fallbackMethod = "fallback")
  public String add(@RequestParam("a") Integer a,@RequestParam("b") Integer b) {
	int c = a/b ;//当b=0的时候，程序报错，直接回调fallback方法，进行熔断。
    String string = this.testFeignClient.add(a,c);
    return string;
  }
  /**
   * hystrix fallback方法
   * @param id id
   * @return 默认的用户
   */
  public String fallback(Integer a,Integer b) {
   return "异常发生，进入fallback方法，接收的参数：a = {} ,b={}";
  }
}