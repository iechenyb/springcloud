package com.example.jwtauth.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.jwtauth.dao.MyUserRepository;
import com.example.jwtauth.po.MyUser;

import static java.util.Collections.emptyList;

import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
    private MyUserRepository applicationUserRepository;

    public UserDetailsServiceImpl(MyUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @SuppressWarnings("unchecked")
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser applicationUser = applicationUserRepository.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), (Collection<? extends GrantedAuthority>) emptyList());
    }
}
