package com.spring.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity(debug = true)
@ComponentScan(basePackages="com")
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private DataSource dataSource;
	
	public SecurityConfig() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public void configure (AuthenticationManagerBuilder auth) throws Exception{
		
//		auth
//		.inMemoryAuthentication()
//		.withUser("abhishek").password("$2a$10$KmQyxkNY1kBWktHNWRy24OldFBtqVTeNhsTU2c3OXgS4h8fdPoIAC").roles("USER")
//		.and()
//		.withUser("sumit").password("$2a$10$aR9xpvhud5oO7FIqaNs83uR1xMT7tFt7W4DrML4njjT7lmyb4mKGy").roles("ADMIN");
//		
//		
//		System.out.println("The encoded password is" +bCryptPasswordEncoder.encode("abhishek"));
		
		auth
		.jdbcAuthentication()
		.dataSource(dataSource)
//		.usersByUsernameQuery("select username, password, enabled from users "
//		+"where username = ?")
//		.authoritiesByUsernameQuery("select username, authority from authorities "
//				+ "where username = ?")
		.passwordEncoder(passwordEncoder);
		
		System.out.println(dataSource);
		
		
	}
	
	@Override
	public void configure (HttpSecurity http) throws Exception
	{
		http
		.authorizeRequests()
		.antMatchers("/check","/signup").permitAll()
		.antMatchers("/home").hasAuthority("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/myCustomLogin").loginProcessingUrl("/process-login")
		.permitAll()
		.and()
		.logout()
		.and().exceptionHandling().accessDeniedPage("/access-denied");
	}
	
	@Bean
	PasswordEncoder getPasswordEncoder() {
		//return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder();
		}
	
	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource driverManagerDataSource =  new DriverManagerDataSource();
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/employeeInfo");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("amit1996");
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		driverManagerDataSource.getUsername();
		driverManagerDataSource.getPassword();
		//driverManagerDataSource.getDriverClassName();
		System.out.println("Inside driver Manager");
		
		
		return driverManagerDataSource;
	}

	
}
	

	

