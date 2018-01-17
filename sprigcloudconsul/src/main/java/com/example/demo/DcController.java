package com.example.demo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *作者 : iechenyb<br>
 *类描述: 说点啥<br>
 *创建时间: 2018年1月16日
 */
@RestController
public class DcController {
	Log log = LogFactory.getLog(DcController.class);
	@Autowired
    DiscoveryClient discoveryClient;

    @SuppressWarnings("deprecation")
	@GetMapping("/dc")
    public String dc() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(discoveryClient.getLocalServiceInstance().getServiceId());
        System.out.println(services);
        return services;
    }
}
