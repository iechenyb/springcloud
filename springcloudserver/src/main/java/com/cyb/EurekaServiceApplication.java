package com.cyb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableEurekaServer         //����eureka����
@SpringBootApplication      //springBootע��,spring��springBoot����֮����������Ŀ implements EmbeddedServletContainerCustomizer
public class EurekaServiceApplication{
	 @ResponseBody
	    @RequestMapping(value="/")
	    String location(){
	        return "����";
	    }
    //spirng boot�ı�׼���
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