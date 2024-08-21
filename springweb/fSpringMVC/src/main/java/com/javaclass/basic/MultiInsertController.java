package com.javaclass.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaclass.basic.model.MemberVO;
import com.javaclass.basic.model.MemberVOList;

@Controller
public class MultiInsertController {
	@RequestMapping("multiInsert.do")
	public void multiInsert(MemberVOList memberlist) {
		for(MemberVO vo :memberlist.getList()) {
			//System.out.println(vo.toString());
			
		}
	}
}
