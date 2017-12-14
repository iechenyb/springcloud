package com.example.jwtauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JwtauthApplicationNoAno extends SpringBootServletInitializer{

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// user or admin can visit
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@RequestMapping("/home")
	@ResponseBody
	public String home() {
		return "home";
	}

	// admin can visit
	@RequestMapping("/admin")
	@ResponseBody
	public String admin() {
		return "admin";
	}

	// user can visit
	@RequestMapping("/user")
	@ResponseBody
	public String user() {
		return "user";
	}
	
	@Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(JwtauthApplicationNoAno.class);  
    }  
	
	public static void main(String[] args) {
		SpringApplication.run(JwtauthApplicationNoAno.class, args);
	}
}
