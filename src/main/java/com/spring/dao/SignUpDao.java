package com.spring.dao;

import com.spring.model.SignUpDTO;

public interface SignUpDao {

	
	public int saveCredential(SignUpDTO signup);
}
