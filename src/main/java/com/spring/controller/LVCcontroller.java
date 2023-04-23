package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.model.UserInfo;

@Controller
public class LVCcontroller {

	ArrayList <String> list = new ArrayList<String>();
	
	//String country="India";
	
	public LVCcontroller() {
		// TODO Auto-generated constructor stub
		list.add("India");
		list.add("America");
	}

	@RequestMapping("/home")
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
}
