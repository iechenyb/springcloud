package com.cyb.config;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
/**
 *作者 : iechenyb<br>
 *类描述: 说点啥<br>
 *创建时间: 2018年1月11日
 */
@Component
@PropertySource(value = "classpath:application.properties",encoding = "utf-8")
//@Configuration
public class BlogProperties {
	Log log = LogFactory.getLog(BlogProperties.class);
	
	@Value("${com.cyb.blog.name}")
    private String name;//博客作者
   
    @Value("${com.cyb.blog.title}")
    private String title;//博客标题

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
    
}
