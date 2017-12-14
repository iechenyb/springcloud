package com.example.jwtauth.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.jwtauth.dao.JpaUserRepository;
import com.example.jwtauth.dao.UserDaoImpl;
import com.example.jwtauth.po.MyUser;

/**
 *作者 : iechenyb<br>
 *类描述: 用户管理测试<br>
 *创建时间: 2017年12月13日
 */
@Controller
@RequestMapping("/users")
public class UserController {

    private JpaUserRepository applicationUserRepository;
    
    @Autowired
    UserDaoImpl userDaoImpl;
    
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(JpaUserRepository myUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder,AuthenticationManager authenticationManager ) {
        this.applicationUserRepository = myUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/getUser")
    @ResponseBody
    public MyUser MyUser(String username){
    	return userDaoImpl.getUserByName(username);
    }
    
    @Autowired
    private  AuthenticationManager authenticationManager ;//= new SampleAuthenticationManager();

    /*@GetMapping("/mylogin")
    public ModelAndView mylogin() {
    	ModelAndView model = new ModelAndView();
        model.addObject("title", "Welcome - Spring Security Hello World");
        model.addObject("message", "This is welcome page!");
        model.setViewName("login");
        System.out.println("正在跳转到登录页面！");
        return model;
    }*/
    
   /*@RequestMapping(value = "/toLogin", method=RequestMethod.GET)
    public ModelAndView mylogin() {
    	ModelAndView model = new ModelAndView();
        model.addObject("title", "Welcome - Spring Security Hello World");
        model.addObject("message", "This is welcome page!");
        model.setViewName("/login");
        System.out.println("正在跳转到登录页面！");
        ModelAndView mv = new ModelAndView("/user/save/result");//默认为forward模式  
        mv = new ModelAndView("redirect:/user/save/result");//redirect模式  
        return model;
    }
    */
    @RequestMapping("/toRedirect")  
    public String helloJsp(){  
        System.out.println("HelloController.helloJsp().hello=");  
        return "redirect:/lhmj/login.jsp";
    }  
    
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody MyUser user) {
    	 try {
             Authentication request = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
             System.out.println("before:" + request);
             Authentication result = authenticationManager.authenticate(request);
             System.out.println("after:" + result);
             SecurityContextHolder.getContext().setAuthentication(result);
         } catch (AuthenticationException e) {
             System.out.println("Authentication failed: " + e.getMessage());
             return "登录失败";
         }
		return "登录成功";
    }
    
    @PostMapping("/exit")
    @ResponseBody
    public String exit(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
    	 try {
    		 Assert.notNull(request, "HttpServletRequest required");
	         HttpSession session = request.getSession(false);
	         if (session != null) {
	              session.invalidate(); //使当前会话失效
	         }
    	     SecurityContextHolder.clearContext(); //清空安全上下文
         } catch (AuthenticationException e) {
             System.out.println("Authentication failed: " + e.getMessage());
             return "退出失败";
         }
    	 System.out.println("用户退出！");
		return "退出成功";
    }
    
    @PostMapping("/signup")
    @ResponseBody
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