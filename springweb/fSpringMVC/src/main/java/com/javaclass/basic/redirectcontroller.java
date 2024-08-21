package com.javaclass.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class redirectcontroller {

	@RequestMapping("insert.do")
	public String insert() {
		System.out.println("insert.do 요청");
		//return "select" 단순하게 뷰페이지를 select.jsp지정
		//************************
		//리다이렉팅하기
		//return "redirect:select.do";
		return "select";
		
	}
	
	@RequestMapping("select.do")
	public void select() {
		System.out.println("select.do 요청");
		
	}
}
