package com.javaclass.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javaclass.basic.model.MemberVO;

@Controller//[1]컨트롤러 부여
public class ModelValueController {
	
	@Autowired//VO에서 자동으로 값을 주입 받을 수 있게 지정 (AOP)
	private MemberVO member;
	
	@RequestMapping("modelValue.do")
	public ModelAndView modelValueDO() {
		System.out.println("modelValue.do 요청 확인");
		//흐름 파악을 위해서 여기서 출력이 되는지 확인을 해줘야한다.
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("modelValue");
		mv.addObject("message","우리조 화이팅!");
		mv.addObject("data","중간 화이팅!");
		
		return mv;
	}
	@RequestMapping("modelValue")
	public ModelAndView modelValue() {
		System.out.println("modelValue.do 요청 확인");
		//흐름 파악을 위해서 여기서 출력이 되는지 확인을 해줘야한다.
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("modelValue");
		mv.addObject("data",member);
		
		return mv;
	}
}
