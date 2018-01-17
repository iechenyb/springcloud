package com.cyb.service;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyb.web.User;
/**
 * 
 * @author DHUser
 *  从service层通过http调用服务
 */
@FeignClient("SERVICE-B")
public interface ComputerFeignService {
	
  @RequestMapping("/add")
  public String add(@RequestParam("a") Integer a,@RequestParam("b") Integer b);
  
  /**
   * 
   *作者 : iechenyb<br>
   *方法描述: Method has too many Body parameters: public abstract java.lang.Long 
   *com.cyb.service.ComputerFeignService.sub(java.lang.Long,java.lang.Long)<br>
   *方法申明时，顶多一个非@requestparam注解的参赛，可以多个@requestparam注解的参数！
   *创建时间: 2017年7月15日
   *@param a
   *@param b
   *@return
   */
  @RequestMapping("/sub")
  public Long sub(@RequestParam("a")Long a,@RequestParam("a")Long b);
  
  @RequestMapping("/div")
  public Long div(@RequestParam("a") Long a,@RequestParam("b") Long b);
  
  @RequestMapping("/multi")
  public Long multi(@RequestParam("a") Long a,@RequestParam("b") Long b);
  
  //返回字符串，是否可以不通过json的方式传递参数，直接用对象传递？？？！
  @RequestMapping(value = "/object", method = RequestMethod.POST,
          produces = MediaType.APPLICATION_JSON_VALUE, 
          consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public String object(@RequestBody User user);
  
  //返回对象测试
  @RequestMapping(value = "/retUser/{name}",
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
  
}