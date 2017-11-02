package com.cyb.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author iechenyb
 * 根据实际环境选择最佳的服务方
 * 负载均衡熔断
 */
@RestController
public class ConsumerController {
    Log log = LogFactory.getLog(getClass());
  
    @Autowired  
    private RibbonHystrixService ribbonHystrixService;  

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(@RequestParam Integer a,@RequestParam Integer b) {
    	log.info("负载均衡开始！");
    	//随机访问策略localhost:8881，注意restTemplate的调用函数的写法，直接是服务名，而不是http服务地址
        return ribbonHystrixService.findById(a, b);
    	
    }
    
}