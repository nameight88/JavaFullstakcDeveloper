package com.javaclass.basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class reviewController {
		/*
		 * model and view
		 */
		@RequestMapping("/test1")
		public ModelAndView reviewTest1() {
			System.out.println("test1 요청확인");
			ModelAndView mv = new ModelAndView();
			mv.addObject("result","결과값1");
			mv.addObject("data","데이터값1");
			mv.setViewName("result");
			return mv;
		}
		
		/*[2] 리턴형을 void
		 * 
		 */
		@RequestMapping("/result")
		public void test2(Model m) {
			m.addAttribute("result", "결과값2");
			m.addAttribute("data", "데이터값2");
			System.out.println("test2 요청확인");
		}
		
		/*[3]리턴형을 스트링
		 * 
		 */
		@RequestMapping("/test3")
		public String reviewTest3(Model m) {
			System.out.println("test3 요청확인");
			m.addAttribute("result","결과값3");
			m.addAttribute("data","데이터값3");
			return "result";
		}
}
