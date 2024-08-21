package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	//static에 정적 데이터들이 들어가고
	@RequestMapping("/")
	public String index(Model m) {
		
		m.addAttribute("test","Hello thymeleaf");
		
		return "index";
	}
}
