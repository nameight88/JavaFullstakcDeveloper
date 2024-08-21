package com.javaclass.basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewDataController {
	//1.modelandview 요청시
	@RequestMapping("modelandview.do")
	public ModelAndView ModeAndView() {
		System.out.println("modelandview.do");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("model");
		mv.addObject("message","우리조 화이팅!");
		mv.addObject("data","중간 화이팅!");
		return mv;//setviewname후 리턴을 해줘야한다.
	}
	//2 model.do 요청시
	@RequestMapping("model.do")
	public void model(Model m) {
		System.out.println("model.do");
		m.addAttribute("message","우리팀 화이팅!");
		m.addAttribute("data","중간 화이팅!");
	}
	//3.String.do 요청시
	@RequestMapping("string.do")
	public String StringDo(Model m) {
		 //원하는 페이지를 값을 보내서 받고가 아니라 문자열로 설정하면 된다.
		m.addAttribute("message","우리팀 화이팅!");
		m.addAttribute("data","중간 화이팅!");
		return "model";
	}
	
	/* ************************
	 * 뷰페이지로 데이터 전송하는 방식
	 * 1) ModelAndView 에 지정해서 리턴
	 * 2) Model을 인자로 지정해서 값 넣고 난 후 리턴
	 */
}

