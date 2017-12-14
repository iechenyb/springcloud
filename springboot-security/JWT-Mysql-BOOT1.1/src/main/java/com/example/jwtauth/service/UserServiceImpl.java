package com.example.jwtauth.service;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.jwtauth.dao.JpaUserRepository;
import com.example.jwtauth.dao.UserDaoImpl;
import com.example.jwtauth.po.MyUser;
/**
 *作者 : iechenyb<br>
 *类描述: 说点啥<br>
 *创建时间: 2017年12月13日
 */
@Repository
public class UserServiceImpl {
	
	@Autowired
	UserDaoImpl userDao;
	
	@Autowired
	JpaUserRepository jpaUserRepository;
	
	@Transactional
	public void updateTX(int hasException,String newName){
		userDao.updateTx(hasException,newName);
	}
	
	public MyUser getUserByName(String userName){
		return userDao.getUserByName(userName);
	}
}
