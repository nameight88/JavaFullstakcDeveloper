package com.javaclass.basic;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaclass.basic.model.MemberVO;

@Controller
public class ParameterController {
	/* ***************
	 * 스프링에서 세션을 사용할려면?
	 * 	인자에 httpsSession 변수만 선언하면 된다.
	 * 	
	 */
	
	@RequestMapping("param.do")
	public void param(String id, Integer age) {
		System.out.println("param.do 요청 확인"+id+"/"+age);
	}
	@RequestMapping("paramForm.do")
	public void paramForm(MemberVO vo,HttpSession session)
	{
		System.out.println("paramForm.do요청 확인");
		String dbid="999";
		String dbname="홍길동";
		//로그인작업
		if(dbid.equals(vo.getId()) && dbname.equals(vo.getName())) {
			session.setAttribute("login", dbname);
		}
	}
}
