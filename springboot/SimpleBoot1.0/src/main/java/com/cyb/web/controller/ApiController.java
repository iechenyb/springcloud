package com.cyb.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}