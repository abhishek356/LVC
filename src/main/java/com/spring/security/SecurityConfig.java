package com.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity(debug = true)
@ComponentScan(basePackages="com.spring")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	PasswordEncoder bCryptPasswordEncoder;
	public SecurityConfig() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public void configurerGlobal (AuthenticationManagerBuilder auth) throws Exception{
		
		auth
		.inMemoryAuthentication()
		.withUser("abhishek").password("$2a$10$KmQyxkNY1kBWktHNWRy24OldFBtqVTeNhsTU2c3OXgS4h8fdPoIAC").roles("USER")
		.and()
		.withUser("sumit").password("$2a$10$aR9xpvhud5oO7FIqaNs83uR1xMT7tFt7W4DrML4njjT7lmyb4mKGy").roles("ADMIN");
		
		
		System.out.println("The encoded password is" +bCryptPasswordEncoder.encode("abhishek"));
	}
	
	@Override
	public void configure (HttpSecurity http) throws Exception
	{
		http
		.authorizeRequests()
		.antMatchers("/check").permitAll()
		.antMatchers("/home").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll();
	}

	
}
	

	

