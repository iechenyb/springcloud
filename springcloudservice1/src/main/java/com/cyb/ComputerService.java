package com.cyb;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class ComputerService {
 @RequestMapping("info")
 public String info(String name){
	 return "information about project";
 }
 @RequestMapping("hello")
 public String hello(String name){
	 return "hell,"+name+"!";
 }
 @RequestMapping("/")
 public String index(String name){
	 return "hell index!";
 }
}
