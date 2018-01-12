package com.cyb.endpoint;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.actuate.endpoint.Endpoint;
/**
 *作者 : iechenyb<br>
 *类描述: 自定义扩展功能<br>
 *https://segmentfault.com/a/1190000004318360?_ea=568366
 *创建时间: 2018年1月10日
 */
public class MyEndPoint implements Endpoint<MemInfo>{
	Log log = LogFactory.getLog(MyEndPoint.class);
	  /** 
     * (1) getId是EndPoint的唯一标识， 
     * (2)MVC接口对外暴露的路径:http://localhost:8080/myendpoint 
     */ 
	public String getId() {
		return "myendpoint";
	}

	public MemInfo invoke() {
		MemInfo memInfo = new MemInfo();  
        Runtime runtime = Runtime.getRuntime();  
        memInfo.setRecordTime(new Date());  
        memInfo.setMaxMemory(runtime.maxMemory());  
        memInfo.setTotalMemory(runtime.totalMemory());  
        return memInfo; 
	}

	public boolean isEnabled() {
		return true;
	}

	public boolean isSensitive() {
		return false;
	}
}
