package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	
	//@ResponseBody
	@RequestMapping("/test")
	public String home()
	{
		return "hello";
	}
}
