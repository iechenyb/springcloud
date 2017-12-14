package com.example.jwtauth.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.jwtauth.po.MyUser;

@Repository
public class UserDaoImpl {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public MyUser getUserByName(String userName){
		
		return this.jdbcTemplate.queryForObject("select user_id,username,password from ms_security_user where username='"+userName+"'", new RowMapper<MyUser>() {

			@Override
			public MyUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				System.out.println("读取用户信息。。。");
				MyUser user = new MyUser();
				user.setUser_id(rs.getLong("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		});
       //return  this.jdbcTemplate.queryForObject("select user_id,username,password from ms_security_user where username='"+userName+"'", MyUser.class);		
	}
	
}
