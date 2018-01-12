package com.cyb.endpoint;
/**
 *作者 : iechenyb<br>
 *类描述: 说点啥<br>
 *创建时间: 2018年1月10日
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;  
  
@Configuration  
public class EndPointAutoConfig {  
      
     @Bean  
     public MyEndPoint myEndPoint() {  
         return new MyEndPoint();  
     }  
}  