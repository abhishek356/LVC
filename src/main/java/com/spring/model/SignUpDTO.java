package com.spring.model;

import org.springframework.stereotype.Component;

@Component
public class SignUpDTO {

	private String username;
	
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SignUpDTO [username=" + username + ", password=" + password + "]";
	}
	
	
	

}
