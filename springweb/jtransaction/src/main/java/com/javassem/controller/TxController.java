
package com.javassem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javassem.service.ServiceTx;
import com.javassem.vo.CustomerVO;
import com.javassem.vo.MemberVO;


@Controller
public class TxController {
	@Autowired
	private ServiceTx service;
	
	@RequestMapping(value="/form.do")
	public String txForm(){
		return "form";
	}
	
	@RequestMapping(value="/transfer.do",method=RequestMethod.POST)
	public ModelAndView addAll(CustomerVO cvo,MemberVO mvo) throws Exception{
		service.addAll(cvo, mvo);
		
//		System.out.println(cvo.toString());
//		System.out.println(mvo.toString());
		//데이터베이스에 입력을 할때의 중복되는 값이 있으면 변수명을 맞춰주면 똑같이 다 들어간다.
		//다른 테이블에서 유니크 값으로 중복되는 값을 넣으면 한쪽에서만 들어가게되는데
		//이때 필요한게 트랜젝션인다
		ModelAndView ma = new ModelAndView("result");
		ma.addObject("msg","성공적으로 입력되었습니다.");
		return ma;
	}
}
