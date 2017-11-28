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

import com.cyb.entity.InterfaceLimit;
import com.cyb.service.InterfaceLimitService;
/**
 * 
 *作者 : iechenyb<br>
 *方法描述: 提供服务类<br>
 *创建时间: 2017年7月15日hj12
 */
@RestController
public class ComputeController {

    private final Logger logger = Logger.getLogger(getClass());
    
    @SuppressWarnings("unused")
	@Autowired
    private InterfaceLimitService service;
 
    @Autowired
    private DiscoveryClient client;
    /**
     * 
     *作者 : iechenyb<br>
     *方法描述: 提供加法服务<br>
     *创建时间: 2017年7月15日hj12
     *@param a
     *@param b
     *@return
     */
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public String add(@RequestParam Integer a, @RequestParam Integer b,HttpServletRequest request) {
    	InterfaceLimit limit = new InterfaceLimit();
        //是否尝试失败
        if (Integer.parseInt("2") <= limit.getUnitNum()) {
	        ServiceInstance instance = client.getLocalServiceInstance();
	        Integer r = a + b;
	        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
	        return "From Service-B, Result is " + r+"\nPort:"+instance.getPort()+",sessionid is "+request.getSession().getId();
        }
        return "调用次数超限！";
    }

}