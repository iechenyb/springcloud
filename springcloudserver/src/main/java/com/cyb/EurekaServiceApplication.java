package com.cyb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableEurekaServer         //开启eureka服务
@SpringBootApplication      //springBoot注解,spring在springBoot基础之上来构建项目 implements EmbeddedServletContainerCustomizer
public class EurekaServiceApplication{
	 @ResponseBody
	    @RequestMapping(value="/")
	    String location(){
	        return "北京";
	    }
    //spirng boot的标准入口
    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceApplication.class, args);
    }
    /*@SuppressWarnings("unchecked")
	@Bean
    public EmbeddedServletContainerFactory servletContainer(){
    	TomcatEmbeddedServletContainerFactory factory= new TomcatEmbeddedServletContainerFactory();
    	factory.setPort(8888);
    	factory.setSessionTimeout(10,TimeUnit.MINUTES);
    	factory.setErrorPages((Set<ErrorPage>) new ErrorPage(HttpStatus.NOT_FOUND,"/404.html"));
    	return factory;
    }*/
	/*public void customize(ConfigurableEmbeddedServletContainer c) {
		c.setPort(8888);
		
	}*/
}