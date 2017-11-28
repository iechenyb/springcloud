package com.cyb.demo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloJsp {
	@RequestMapping("/index")
	public String index(Map<String,Object> map){
		map.put("name", "Andy");
		return "index";
	}
}
