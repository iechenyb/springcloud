package com.cyb.config;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
/**
 *作者 : iechenyb<br>
 *类描述: 说点啥<br>
 *创建时间: 2017年12月14日
 */
public class DubboBaseConfig {
	Log log = LogFactory.getLog(DubboBaseConfig.class);
	   //@Bean
	    public RegistryConfig registry() {
	        RegistryConfig registryConfig = new RegistryConfig();
	        registryConfig.setAddress("127.0.0.1:2181");
	        registryConfig.setProtocol("zookeeper");
	        return registryConfig;
	    }
	    
	    //@Bean
	    public ApplicationConfig application() {
	        ApplicationConfig applicationConfig = new ApplicationConfig();
	        applicationConfig.setName("testApp");
	        return applicationConfig;
	    }
	    
	    //@Bean
	    public MonitorConfig monitorConfig() {
	        MonitorConfig mc = new MonitorConfig();
	        mc.setProtocol("registry");
	        return mc;
	    }
	    
	    @SuppressWarnings("rawtypes")
		//@Bean
	    public ReferenceConfig<?> referenceConfig() {
	        ReferenceConfig rc = new ReferenceConfig();
	        rc.setMonitor(monitorConfig());
	        return rc;
	    }
	    
	    //@Bean
	    public ProtocolConfig protocol() {
	        ProtocolConfig protocolConfig = new ProtocolConfig();
	        protocolConfig.setPort(20880);
	        return protocolConfig;
	    }
	    
	    //@Bean
	    public ProviderConfig provider() {
	        ProviderConfig providerConfig = new ProviderConfig();
	        providerConfig.setMonitor(monitorConfig());
	        return providerConfig;
	    }
	    
	    
}
