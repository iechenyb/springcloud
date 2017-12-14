package com.example.jwtauth.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.jwtauth.filter.JWTLoginFilter;
import com.example.jwtauth.filter.JwtAuthenticationFilter;
/**
 * hasrole不生效原因
 * http://blog.csdn.net/sinat_28454173/article/details/52312828
 * @author DHUser
 *
 */
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsService userDetailsService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public MyWebSecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/users/signup").permitAll()
                .antMatchers(HttpMethod.POST, "/users/login").permitAll()
                .antMatchers(HttpMethod.GET, "/users/toLogin").permitAll()
                .antMatchers(HttpMethod.GET, "/users/toRedirect").permitAll()
                .antMatchers(HttpMethod.GET, "/login.jsp").permitAll()
                .antMatchers(HttpMethod.GET, "/users/exit").permitAll()
                .anyRequest().authenticated()
                .antMatchers("/home").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")  
                .antMatchers("/user").access("hasRole('ROLE_USER')") 
                .antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
                .and()
                .formLogin().loginPage("/users/toRedirect").permitAll()
                .and()
                .addFilter(new JWTLoginFilter(authenticationManager()))
                .addFilter(new JwtAuthenticationFilter(authenticationManager()));
		        /*http
		        .authorizeRequests()
		            .anyRequest().hasRole("USER")
		            .and()
		       .formLogin()
		            .permitAll()
		            .and()
		       .sessionManagement()
		            .maximumSessions(1)
		            .expiredUrl("/users/exit?expired");*/
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
    
}
