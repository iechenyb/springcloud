package com.cyb.web.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 *作者 : iechenyb<br>
 *类描述: 默認加載application.properties的屬性<br>
 *创建时间: 2018年3月1日
 */
@Component
public class ApplicationConfigure {
	
	@Value("${cyb.app.name}")
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
