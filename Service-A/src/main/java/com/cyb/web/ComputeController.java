package com.cyb.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
/**
 * 
 *作者 : iechenyb<br>
 *方法描述: 提供服务类
 * add是调用当前服务的方法<br>
 * testServiceB 通过在当前服务中调用b服务
 *创建时间: 2017年7月15日hj12
 */
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
     *@param a
     *@param b
     *@return
     */
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public String add(@RequestParam Integer a, @RequestParam Integer b,HttpServletRequest request) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return "From Service-A, Result is " + r+" port is"+instance.getPort()+",sessionid is "+request.getSession().getId();
    }

    /**
     * 
     *作者 : iechenyb<br>
     *方法描述: A服务调用B服务<br>
     *创建时间: 2017年7月15日hj12
     *@param a
     *@param b
     *@return
     */
    @RequestMapping(value="testServiceB",method=RequestMethod.GET)
    public String testServiceB(@RequestParam Integer a,@RequestParam Integer b){
    	RestTemplate restTemplate=new RestTemplate();
    	return restTemplate.getForObject("http://localhost:8881/add?a="+a+"&b="+b, String.class);
    }

}