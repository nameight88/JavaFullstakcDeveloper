package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.HttpServerErrorException;

import com.example.domain.MemberVO;
import com.example.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
@SessionAttributes("mem")
public class MemberController {
	
	//세션을 쓰는 방법이 2가지
	
	//Httpsession 을 이용해서 사용 하는 것과
	//@@SessionAttributes 어노테이션을 이용해서 모델을 사용한 것을 세션에 등록 하는 방법
	
	static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberservice;

	//------------------------------
	@PostMapping("/checkLogin")
	public String checkLogin(MemberVO vo,Model m,HttpSession session) {
//		System.out.println("화면에서 넘어온 값"+vo);
		MemberVO result = memberservice.checkLogin(vo);
//		System.out.println("결과 : "+result);
		if(result != null) {
			
			// 뷰 페이지에 데이터 전송
			m.addAttribute("mem",result);
			
			// 세션에 저장 (모든 뷰 페이지에서 데이터 이용 가능)
			session.setAttribute("sess", result);
			return"/memeber/loginSuccess";
		}else {
			return"/memeber/loginForm";
		}
	}

	@RequestMapping("/insertMember")
	public String insertMember(MemberVO vo) {
		memberservice.insertMember(vo);
		return "redirect:regist";
	}
	
	
	@RequestMapping("/{step}")
	public String viewPage(@PathVariable String step) { 
		logger.info(step + "경로 들어옴");
		return "member/"+step;
	}
	
	@RequestMapping("/test")
	public void test() {
		System.out.println("/member/test 요청");
	}
}
