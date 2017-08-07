package com.cyb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloJsp {
@RequestMapping	
 public String index(){
	 return "/index";
 }
}
