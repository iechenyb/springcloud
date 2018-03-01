package com.cyb;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient.EurekaServiceInstance;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//http://127.0.0.1:8880/myendpoint
@EnableDiscoveryClient
@SpringBootApplication
public class A_Application {
    //同一个应用通过端口号，启动两个服务程序
	public static void main(String[] args) {
		//https://www.cnblogs.com/softidea/p/5759180.html
		//控制台输入端口
		/*Scanner scan = new Scanner(System.in);
		String port=scan.nextLine();*/
		new SpringApplicationBuilder(A_Application.class)
		//.properties("server.port="+port)//指定启动端口
		.web(true)
		//.profiles("dev")
		.run(args);
		
	}
	//http://127.0.0.1:8880/service-instances/SERVICE-A
	@RestController
	class ServiceInstanceRestController {

	    @Autowired
	    private DiscoveryClient discoveryClient;

	    @RequestMapping("/service-instances/{applicationName}")
	    public List<ServiceInstance> serviceInstancesByApplicationName(
	            @PathVariable String applicationName) {
	    	List<String> serviceIds = discoveryClient.getServices();
	    	System.out.println(serviceIds);
	    	for(String sid:serviceIds){
	    		EurekaServiceInstance x;
	    		List<ServiceInstance> sls = discoveryClient.getInstances(sid);
	    		for(ServiceInstance si:sls){
	    			x = (EurekaServiceInstance) si;
	    			System.out.println(x.getInstanceInfo().getStatus()+","+sid+","+si.getPort()+","+si.getMetadata());
	    			
	    		}
	    	}
	        return this.discoveryClient.getInstances(applicationName);
	    }

	    @RequestMapping("/")
	    public String sayhello() {
	        return "hello";
	    }
	}
}
