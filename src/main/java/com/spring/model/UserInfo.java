package com.spring.model;

public class UserInfo {




	
	private String userName;
	private String crushName;
	private String password;
	private String country;
	private String hobby;
	private String gender;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCrushName() {
		return crushName;
	}
	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}
	@Override
	public String toString() {
		return "UserInfo [userName=" + userName + ", crushName=" + crushName + ", password=" + password + ", country="
				+ country + ", hobby=" + hobby + ", gender=" + gender + "]";
	}
	
	}
	
	



