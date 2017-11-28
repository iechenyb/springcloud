package com.cyb.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 *作者 : iechenyb<br>
 *方法描述: 提供服务类
 * add是调用当前服务的方法<br>
 * testServiceB 通过在当前服务中调用b服务
 *创建时间: 2017年7月15日hj12
 */
@RestController
public class SessionController {

    @RequestMapping(value = "/first", method = RequestMethod.GET)  
    public Map<String, Object> firstResp (HttpServletRequest request){  
        Map<String, Object> map = new HashMap<String, Object>();  
        request.getSession().setAttribute("request Url", request.getRequestURL());  
        map.put("request Url", request.getRequestURL());  
        return map;  
    }  
  
    @RequestMapping(value = "/sessions", method = RequestMethod.GET)  
    public Object sessions (HttpServletRequest request){  
        Map<String, Object> map = new HashMap<String, Object>();  
        map.put("sessionId", request.getSession().getId());  
        map.put("message", request.getSession().getAttribute("map"));  
        return map;  
    }  

}