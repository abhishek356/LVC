package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.spring.dao.SignUpDao;
import com.spring.model.SignUpDTO;
import com.spring.model.UserInfo;

@Controller
public class LVCcontroller {

	ArrayList <String> list = new ArrayList<String>();
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	SignUpDao signUpDao;
	
	//String country="India";
	
	public LVCcontroller() {
		// TODO Auto-generated constructor stub
		list.add("India");
		list.add("America");
	}

	@RequestMapping("/")
	public String home(@ModelAttribute("userInfo")UserInfo userInfo, Model model)
	{
		
		
		model.addAttribute("countries",list);
		return "home-page";
	}
	
	@RequestMapping("/process-form")
	public String processForm(UserInfo userInfo, Model model)
	{
		System.out.println(userInfo.getUserName());
		System.out.println(userInfo.getCrushName());
		model.addAttribute("user",userInfo);
		return "process-form";
	}
	
	@RequestMapping("/check")
	public String check()
	{
		return "check";
	}
	
	@RequestMapping("/myCustomLogin")
	public String login()
	{
		return "login";
	}
	
	@RequestMapping("/signup")
	public String signUp(@ModelAttribute("SignUpDTO") SignUpDTO signup)
	{
	return "signUp";	
	}
	
		
	@PostMapping("/process-signUp")
	public String processSignUp(SignUpDTO signup)
	{
		String encoded = passwordEncoder.encode(signup.getPassword());
	
		signup.setPassword(encoded);
		System.out.println("Encoded password is "+encoded);
		signUpDao.saveCredential(signup);
		
	return "redirect:/myCustomLogin";	
	}
	
	@RequestMapping("/access-denied")
	public String accessDenied()
	{
	return "accessDenied";	
	}
	
	@RequestMapping("/UpdateRoles")
	public String updateRoles()
	{
	return "UpdateRoles";	
	}
}
