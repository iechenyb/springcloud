package com.cyb.web;

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


@RestController
public class ComputeController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;
    
    //http://localhost:8882/anystr?a=1&b=234   /**
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public String add(@RequestParam Integer a, @RequestParam Integer b,HttpServletRequest req) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return "From Service-B2, Result is " + r+"\nPort:"+instance.getPort()+",sessionid is "+req.getSession().getId();
    }

    //B服务调用A服务 http://localhost:8882/testServiceA?a=1&b=234
    @RequestMapping(value="testServiceA",method=RequestMethod.GET)
    public String testServiceB(@RequestParam Integer a,@RequestParam Integer b){
    	RestTemplate restTemplate=new RestTemplate();
    	return restTemplate.getForObject("http://localhost:8880/add?a="+a+"&b="+b, String.class);
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