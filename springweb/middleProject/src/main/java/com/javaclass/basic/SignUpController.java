package com.javaclass.basic;




import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.javaclass.vo.AgentVO;
import com.javaclass.vo.UserVO;
import com.javaclass.service.ServiceTx;

@Controller
public class SignUpController {

	@Autowired
	private ServiceTx service;

	@RequestMapping("Userlogin")
	public String SendLoginapage1() {
		return "redirect:login";
	}

	@RequestMapping("Agentlogin")
	public String SendLoginpage2() {
		return "redirect:login2";
	}

	// 요구화면 연결
	// -1. 회원가입:약관동의 페이지
	@RequestMapping("signUp/signUp1")
	public String Sendpage1() {
		return "signUp/signUp1";
	}

	// -2. 회원가입:고객정보 입력 페이지
	@RequestMapping("signUp/signUp2")
	public String Sendpage2() {
		return "signUp/signUp2";
	}

	// -2.1. -> 입력된 고객가입 데이터 전송 및 로그인 페이지 redirect
	@RequestMapping("signUp/transfer.do")
	public String addAll(UserVO uvo) throws Exception{
		service.addAll(uvo);

		return "redirect:/login";
	}

	// -2.2. -> 회원가입:아이디 중복 검사(중개인/고객 통일)
	@RequestMapping("signUp/userIdCheck.do")
	@ResponseBody
	public boolean IdCheck(@RequestParam String checkBeforeId) throws Exception{
		boolean result = service.IdCheck(checkBeforeId);
		return result;
	}

	// -2.3. -> 회원가입:아이디 중복 검사(중개인/고객 통일)
	@RequestMapping("signUp/userEmailCheck.do")
	@ResponseBody
	public boolean EmailCheck(@RequestParam String checkEmail) throws Exception{
		boolean result = service.emailCheck(checkEmail);
		
		return result;
	}

	// -3. 회원가입:중개인정보 입력 페이지
	@RequestMapping("signUp/signUp3")
	public String Sendpage3() {
		return "signUp/signUp3";
	}

	// -3.1. -> 입력된 중개인가입 데이터 전송 및 로그인 페이지 redirect
	@RequestMapping("signUp/transfer2")
	public String addAll2(AgentVO avo) throws Exception{
		service.addAll2(avo);

		return "redirect:/login";
	}

	// -4.1. 로그인 작업
	@RequestMapping("loginForm")
	@ResponseBody
	public String login(@RequestParam String inputId, @RequestParam String inputPass, HttpSession session) throws Exception{
		int resultInt = service.Login(inputId,inputPass);
		boolean result = false;
		switch(resultInt) {
		case 1 : session.setAttribute("user", inputId);
		result = true;   
		break;
		case 2 : session.setAttribute("agent", inputId);
		result = true;
		break;
		case 3 : session.setAttribute("admin", inputId);
		result = true;
		break;
		}      
		return ""+result;
	}

	// -4.2. 계정찾기: 계정 찾기 / 페이지연결
	@RequestMapping("signUp/findAccount")
	public String sendPageFindAccount() {
		return "signUp/findAccount";
	}

	// 999.약관동의 페이지 연결
	@RequestMapping("signUp/termsOfService1")
	public String Sendpage4(){

		return "signUp/termsOfService1";
	}

}
