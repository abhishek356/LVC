package com.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.model.SignUpDTO;

@Repository
public class SignUpDaoImpl implements SignUpDao {

	public SignUpDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int saveCredential(SignUpDTO signup) {
		// TODO Auto-generated method stub
		
		String sql = "Insert into users values (?,?,?)";
		String sql1 = "Insert into authorities values (?,?)";
		
		jdbcTemplate.update(sql,signup.getUsername(),signup.getPassword(),1);
		jdbcTemplate.update(sql1,signup.getUsername(),"USER");
		
		return 1;
	}

}
