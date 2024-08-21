package com.javaclass.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaclass.service.ServiceTx;

@Controller
public class AccountController {
	
	@Autowired
	private ServiceTx service;
	
	@RequestMapping("signUp/findId")
	@ResponseBody
	public String findId(@RequestParam String inputEmail) throws Exception {
		String result = service.findAccountId(inputEmail);

		return result;
	}
	
	String rememberId;
	
	@RequestMapping("signUp/fixPass")
	@ResponseBody
	public boolean fixPass(@RequestParam String inputPwId, String inputPwEmail) throws Exception {
		boolean result = service.findAccountPass(inputPwId,inputPwEmail);
		rememberId = inputPwId;
		return result;
	}
	
	@RequestMapping("signUp/changePass")
	public String changePass() {
		
		return "signUp/changePass";
	}
	
	@RequestMapping("signUp/updatePass")
	@ResponseBody
	public int changePass(@RequestParam String inputNewPw) throws Exception {
		
		service.changeNewUserPassword(inputNewPw, rememberId);
		service.changeNewAgentPassword(inputNewPw, rememberId);
		
		return 1;
	}
}
