package com.example.jwtauth.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.jwtauth.dao.MyUserRepository;
import com.example.jwtauth.po.MyUser;

import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
    private MyUserRepository applicationUserRepository;

    public UserDetailsServiceImpl(MyUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser applicationUser = applicationUserRepository.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), getAuthorities(username));
    }
    
    public Collection<? extends GrantedAuthority> getAuthorities(String username) { 
    	 List<GrantedAuthority> list = new ArrayList<GrantedAuthority>(); 
        // 根据自定义逻辑来返回用户权限，如果用户权限返回空或者和拦截路径对应权限不同，验证不通过  
    	if(username.equals("admin")){
	        GrantedAuthority au = new SimpleGrantedAuthority("ADMIN");  
	        list.add(au);  
	        return list;  
        }else if (username.equals("user")){
        	 GrantedAuthority au = new SimpleGrantedAuthority("USER");  
 	         list.add(au);  
 	        return list;  
        }else{//any
        	GrantedAuthority au1 = new SimpleGrantedAuthority("USER");  
 	        list.add(au1);  
 	        GrantedAuthority au2 = new SimpleGrantedAuthority("ADMIN");  
	        list.add(au2);  
 	        return list; 
        } 
    }  
}
