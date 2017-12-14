package com.cyb.config.dubbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;  
/**
 *作者 : iechenyb<br>
 *类描述: 说点啥<br>
 *创建时间: 2017年12月14日
 */
//@Configuration  
//@EnableConfigurationProperties(DubboProperties.class)//开启属性注入,通过@autowired注入   
//@ConditionalOnClass({AnnotationBean.class,ApplicationConfig.class,ProtocolConfig.class,RegistryConfig.class})  
public class DubboAutoConfiguration {  
  
    /*@Autowired  
    private DubboProperties prop;  */
      
    //@Bean  
    //@ConditionalOnMissingBean(AnnotationBean.class)
    //容器中如果没有这个类,那么自动配置这个类    @Value("com.cyb.service.dubbo")String packageName
    public static AnnotationBean annotationBean(@Value("dubbo.packageName") String packageName) {  
        AnnotationBean annotationBean = new AnnotationBean();  
        annotationBean.setPackage("com.cyb.service.dubbo");  
        return annotationBean;  
    }  
  
    //@Bean  
    //@ConditionalOnMissingBean(ApplicationConfig.class)//容器中如果没有这个类,那么自动配置这个类  
    public ApplicationConfig applicationConfig() {  
        ApplicationConfig applicationConfig = new ApplicationConfig();  
        applicationConfig.setName("firstdubbo");  //prop.getApplication().getName()
        return applicationConfig;  
    }  
  
    //@Bean  
    //@ConditionalOnMissingBean(ProtocolConfig.class)//容器中如果没有这个类,那么自动配置这个类  
    public ProtocolConfig protocolConfig() {  
        ProtocolConfig protocolConfig = new ProtocolConfig();  
        protocolConfig.setName("dubbo");  //prop.getProtocol().getName()
        protocolConfig.setPort(20880);  //prop.getProtocol().getPort()
        return protocolConfig;  
    }  
  
    //@Bean  
    //@ConditionalOnMissingBean(RegistryConfig.class)//容器中如果没有这个类,那么自动配置这个类  
    public RegistryConfig registryConfig() {  
        RegistryConfig registryConfig = new RegistryConfig();  
        registryConfig.setAddress("zookeeper://127.0.0.1:2181"); // prop.getRegistry().getAddress()
        return registryConfig;  
    }  
      
} 
