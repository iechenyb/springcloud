package com.example.jwtauth.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwtauth.po.MyUser;
/**
 *作者 : iechenyb<br>
 *类描述: 说点啥<br>
 *创建时间: 2017年12月13日
 */
public interface JpaUserRepository extends JpaRepository<MyUser, Long> {
    MyUser findByUsername(String username);
}