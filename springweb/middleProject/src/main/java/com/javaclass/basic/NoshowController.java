package com.javaclass.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaclass.service.NoshowService;
import com.javaclass.vo.NoshowVO;

@Controller
public class NoshowController {
	
	@Autowired
	private NoshowService noshowService;
	
	@RequestMapping("agent/noshowInsert")
	@ResponseBody
	public String noshowInsert(NoshowVO vo) {
		
		String result = String.valueOf(noshowService.noshowInsert(vo));
		
		return result;
	}
	@RequestMapping("agent/noshowCancel")
	@ResponseBody
	public String noshowCancel(NoshowVO vo) {
		String result = String.valueOf(noshowService.noshowDelete(vo));
		return result;
	}

}
