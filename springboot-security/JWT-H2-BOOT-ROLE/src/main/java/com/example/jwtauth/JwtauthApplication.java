package com.example.jwtauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JwtauthApplication {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// user or admin can visit
	@PreAuthorize("hasRole('ADMIN') AND hasRole('USER')") 
	@RequestMapping("/home")
    @ResponseBody
    public String home(){
	    return "home";
    }
	
	@PreAuthorize("hasRole('ADMIN')") 
	//admin can visit
	@RequestMapping("/admin")
    @ResponseBody
    public String admin(){
	    return "admin";
    }
	
	@PreAuthorize("hasRole('USER')") 
	// user can visit
    @RequestMapping("/user")
    @ResponseBody
    public String user(){
	    return "user";
    }

	public static void main(String[] args) {
		SpringApplication.run(JwtauthApplication.class, args);
	}
}
