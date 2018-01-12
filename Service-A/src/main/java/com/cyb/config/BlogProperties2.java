package com.cyb.config;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 *作者 : iechenyb<br>
 *类描述: 说点啥<br>
 *创建时间: 2018年1月11日
 */
@Component
@ConfigurationProperties(prefix="com.cyb.blog")
public class BlogProperties2 {
	Log log = LogFactory.getLog(BlogProperties2.class);
	
    private String name;//博客作者
   
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
