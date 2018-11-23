package com.cyb.feign;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//发现远端服务
@FeignClient(name = "COMPUTER-SERVICE")
interface ComputerFeignClient{
	@RequestMapping("/sayHello")
	public String say(@RequestParam("words") String words);
}

@RestController
public class ComputerServiceClient {
	Log log = LogFactory.getLog(ComputerServiceClient.class);
	//本地调用远端服务
	@Autowired
	ComputerFeignClient client;
	
	@RequestMapping("/sayHello")
	public String localMethodName(@RequestParam("words") String words){
		client.say(words);//调用远端服务
		return words;
	}
}
