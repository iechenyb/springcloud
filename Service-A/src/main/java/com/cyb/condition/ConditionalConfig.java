package com.cyb.condition;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
/**
 *作者 : iechenyb<br>
 *类描述: 说点啥<br>
 *创建时间: 2018年1月11日
 */
@Configuration
public class ConditionalConfig {
	Log log = LogFactory.getLog(ConditionalConfig.class);
	@Bean
    @Conditional(WindowsCondition.class)
    public ListService windowsList() { return new WindowsServiceImpl(); }

    @Bean
    @Conditional(LinuxCondition.class)
    public ListService linuxList() { return new LinuxServiceImpl(); }
}
