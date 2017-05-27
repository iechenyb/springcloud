package com.cyb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class DiscoverService {
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("/services")
	public String doFind(){
		StringBuilder bf = new StringBuilder("");
		List<String> sIds = discoveryClient.getServices();
		if(!CollectionUtils.isEmpty(sIds)){
			for(String s:sIds){
				System.out.println("serviceid="+s);
				List<ServiceInstance> ins = discoveryClient.getInstances(s);
				if(!CollectionUtils.isEmpty(ins)){
					for(ServiceInstance si:ins){
						bf.append("["+si.getServiceId()+","+si.getHost()+","+si.getPort()+","+si.getUri()+"],");
					}
				}
			}
		}if(bf.length()>0){
			return bf.toString();
		}else{
			return "no services found!";
		}
	}
}
