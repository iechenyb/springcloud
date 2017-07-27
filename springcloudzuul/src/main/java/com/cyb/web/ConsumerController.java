package com.cyb.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
/**
 * 
 * @author iechenyb
 * 根据实际环境选择最佳的服务方
 */
@RestController
public class ConsumerController {
    Log log = LogFactory.getLog(getClass());
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired  
    private LoadBalancerClient loadBalancerClient;  
    /**
     * 
     *作者 : iechenyb<br>
     *方法描述: a 是偶数调用SERVICE-A服务，否则调用SERVICE-B服务<br>
     *创建时间: 2017年7月15日hj12
     *@param a
     *@param b
     *@return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(@RequestParam Integer a,@RequestParam Integer b) {
    	log.info("负载均衡开始！");
    	String serviceId="SERVICE-B";
    	if(a%2==0){
    		serviceId="SERVICE-A";
    	}
    	this.loadBalancerClient.choose(serviceId);
    	//随机访问策略localhost:8881，注意restTemplate的调用函数的写法，直接是服务名，而不是http服务地址
        return restTemplate.getForEntity("http://"+serviceId+"/add?a="+a+"&b="+b, String.class).getBody();
    	
    }
    
}