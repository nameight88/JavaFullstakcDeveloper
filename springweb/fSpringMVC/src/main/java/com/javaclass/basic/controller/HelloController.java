package com.javaclass.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("start.do")
	public ModelAndView test() {
		System.out.println("클라이언트 start.do 요청을 보냄 - 여기서 서버");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello"); // /WBE-INF/views/ + hello +.jsp
		mv.addObject("dbValue","추후에 디비값");
		mv.addObject("login","아이디");
		
		return mv;
	}
}
