package com.example.jwtauth.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwtauth.dao.MyUserRepository;
import com.example.jwtauth.po.MyUser;

@RestController
@RequestMapping("/users")
public class UserController {

    private MyUserRepository applicationUserRepository;
    
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(MyUserRepository myUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = myUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/signup")
    public String signUp(@RequestBody MyUser user) {
    	if(applicationUserRepository.findByUsername(user.getUsername())!=null){
    		return "你已经注册！";
    	}else{
	        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	        applicationUserRepository.save(user);
	        return "注册成功！";
    	}
    }
}