package com.cyb.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cyb.web.User;

public interface ControllerAware {
	
  @RequestMapping("/fadd")
  public String fadd(Integer a,Integer b);
  
  @RequestMapping("/fadd/{a}/{b}")
  public User faddPath(@PathVariable("a") Integer a,@PathVariable("b") Integer b);
  
  
}