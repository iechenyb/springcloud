package com.example.jwtauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.jwtauth.service.UserServiceImpl;

/**
 *作者 : iechenyb<br>
 *类描述: 用户管理测试<br>
 *创建时间: 2017年12月13日
 */
@Controller
@RequestMapping("/sw")
public class TransactionController {
	
    @Autowired
    UserServiceImpl userService;
    //http://localhost:8080//sw/testSW?has=1&name=qw
    @GetMapping("/testSW")
    @ResponseBody
    public String MyUser(int has,String name){
    	userService.updateTX(has,name);
    	return "测试结束！";
    }
    
}