package com.example;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public void home(Model m) {
		// **********************
		// return void 라면
		// 요쳥명과 동일한 뷰페이지를 지정
		
		//*******************
		// [1] ModelAndView
		// [2] Model
		System.out.println("/home 요쳥 확인");
		m.addAttribute("message","안녕하세요");
		m.addAttribute("serverTime",new Date().toString());
	}
}
