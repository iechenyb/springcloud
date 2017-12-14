package com.example.jwtauth.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.jwtauth.po.MyUser;
/**
 *作者 : iechenyb<br>
 *类描述: 说点啥<br>
 *创建时间: 2017年12月13日
 */
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
	}
	
	//@Transactional
	public void updateTx(int has,String newName){
		try {
			String updateSql1="update ms_security_user set username='"+newName+"' where user_id=1 ";
			String updateSql2="update ms_security_user set username='iechenyb'  where user_id=1";
			this.jdbcTemplate.execute(updateSql1);
			if(has == 1){
				System.out.println(1/0);
			}
			this.jdbcTemplate.execute(updateSql2);
		} catch (DataAccessException e) {
			e.printStackTrace();
			
		}
		
	}
	
}
