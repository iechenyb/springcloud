package com.example.jwtauth.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwtauth.po.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    MyUser findByUsername(String username);
}