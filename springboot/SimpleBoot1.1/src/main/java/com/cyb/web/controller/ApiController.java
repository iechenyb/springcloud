package com.cyb.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyb.web.bean.Req;
import com.cyb.web.config.MyBeanPro;

@RestController
public class ApiController {
	
	@RequestMapping("/now")
	String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
		return sdf.format(new Date());
	}
	@Autowired
    MyBeanPro pro;
	
	@RequestMapping("/")
	String welcome() {
		return "你好！"+pro.getName();
	}
	
	@RequestMapping("/req")
	Req req(HttpServletRequest req) {
		Req r = new Req();
		r.setIp(req.getRemoteHost());
		r.setPort(req.getServerPort()+"");
		r.setUri(req.getRequestURI());
		r.setServerName(req.getServerName());
		return r;
	}
}