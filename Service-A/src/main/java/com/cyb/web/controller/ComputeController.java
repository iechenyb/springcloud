package com.cyb.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cyb.condition.ListService;
import com.cyb.config.BlogProperties;
import com.cyb.config.BlogProperties2;
/**
 * 
 *作者 : iechenyb<br>
 *方法描述: 提供服务类
 * add是调用当前服务的方法<br>
 * testServiceB 通过在当前服务中调用b服务
 *创建时间: 2017年7月15日hj12
 */
import com.cyb.profile.EmailService;
@RestController
public class ComputeController {
    private final Logger logger = Logger.getLogger(getClass());
    
    @Autowired
    private DiscoveryClient client;
    
    /**
     * 
     *作者 : iechenyb<br>
     *方法描述: 调用本身服务<br>
     *创建时间: 2017年7月15日hj12
     *@param a 1212
     *@param b 1212
     *@return 1243
     */
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public String add(@RequestParam Integer a, @RequestParam Integer b,HttpServletRequest request) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return "From Service-A, Result is " + r+" port is"+instance.getPort()+",sessionid is "+request.getSession().getId();
    }
    
    @RequestMapping(value = "/log" ,method = RequestMethod.GET)
    public void testLog(){
    	logger.debug("debugger message!");
    	logger.info("infor message!");
    	logger.error("error message!");
    	logger.warn("warn message!");
    	logger.trace("trace message!");
    }
    /**
     * 
     *作者 : iechenyb<br>
     *方法描述: A服务调用B服务<br>
     *创建时间: 2017年7月15日hj12
     *@param a 13
     *@param b v213
     *@return  12213
     */
    @RequestMapping(value="testServiceB",method=RequestMethod.GET)
    public String testServiceB(@RequestParam Integer a,@RequestParam Integer b){
    	RestTemplate restTemplate=new RestTemplate();
    	return restTemplate.getForObject("http://localhost:8881/add?a="+a+"&b="+b, String.class);
    }
    @Autowired
	ListService service;
    
    @Autowired
    private BlogProperties blogProperties;
    
    @Autowired
    private BlogProperties2 blogProperties1;
    
    @Autowired
    EmailService emailService;
    
    @RequestMapping(value="common",method=RequestMethod.GET)
    public String testcommon(){
    	emailService.send();
    	System.out.println(blogProperties.getName()+","+blogProperties.getTitle());
    	System.out.println(blogProperties1.getName()+","+blogProperties1.getTitle());
    	return "中文返回:"+service.showListCmd()+","+blogProperties.getTitle()+","+blogProperties.getName();
    }
    @RequestMapping(value = "/sub" ,method = RequestMethod.GET)
    public Long sub(Long a,Long b) {
        return a-b;
    }
    
    @RequestMapping(value = "/div" ,method = RequestMethod.GET)
    public Long div(Long a,Long b) {
        return a/b;
    }
    
    @RequestMapping(value = "/multi" ,method = RequestMethod.GET)
    public Long multi(Long a,Long b) {
        return a*b;
    }
    @RequestMapping(value = "/object" ,method = RequestMethod.POST)
    public String  object(@RequestBody User user) {
    	System.out.println("传递对象！"+user.getName());
        return "user is "+user.getName()+","+user.getAge();
    }
    @RequestMapping(value = "/user" ,method = RequestMethod.GET)
    public String  user(@ModelAttribute("user") User user) {
    	System.out.println("传递对象！"+user.getName());
        return "user is "+user.getName()+","+user.getAge();
    }
    @RequestMapping(value = "/retUser/{name}"
    		//,produces = MediaType.APPLICATION_JSON_VALUE
    		,method = RequestMethod.GET)
    public User retUser(@PathVariable(value="name") String name){
    	User user = new User();
    	user.setName(name);
    	user.setAge(new Random().nextInt(500));
		return user;
    }
  //返回对象测试
    @RequestMapping(value = "/retMap",
  		  method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> retMap(){
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("name", "iechenyb");
    	map.put("alis", "chenyuanbao");
    	List<Object> list = new ArrayList<Object>();
    	list.add(1);
    	list.add("hsdlf");
    	map.put("list", list);
    	return map;
    }
    
    //返回对象测试
    @RequestMapping(value = "/retList",
  		  method = RequestMethod.GET)
    @ResponseBody
    public List<Object> retList(){
    	List<Object> list = new ArrayList<Object>();
    	list.add(1);
    	list.add("hsdlf");
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("name", "iechenyb");
    	map.put("alis", "chenyuanbao");
    	list.add(map);
    	return list;
    }
}