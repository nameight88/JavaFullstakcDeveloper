package com.javaclass.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaclass.service.DeclarationService;
import com.javaclass.service.PropertyService;
import com.javaclass.vo.AgentVO;
import com.javaclass.vo.DeclarationVO;
import com.javaclass.vo.PropertyVO;

@Controller
public class DeclarationController {

	@Autowired
	private PropertyService propertyService;

	@Autowired
	private DeclarationService declarationService;

	//허위매물 신고 페이지로 이동
	@PostMapping("report")
	public String report(@RequestParam(value = "property_id") int propertyId,Model m) {
		PropertyVO vo = propertyService.getProperty(propertyId);

		m.addAttribute("property",vo);
		return "report";	
	}

	//허위매물 신고접수
	@RequestMapping("declaration_insert")
	public String report_insert(DeclarationVO vo) {
		
		declarationService.declarationInsert(vo);
		return "redirect:customerpage/qnaAdmin";
	}

	//허위매물 신고 삭제 
	@RequestMapping("/manage/declarationDelete")
	@ResponseBody
	public String declarationDelete(@RequestParam(value = "declaration_num") int declaration_num) {
		declarationService.declarationDelete(declaration_num);
		return "success";
	}
	//허위매물 신고 반려
	@RequestMapping("/manage/declarationPropertyDelete")
	@ResponseBody
	public String declarationPropertyDelete(@RequestParam(value = "declaration_num") int declaration_num,@RequestParam(value = "property_id") int property_id,Model m) {
		m.addAttribute("property_id",property_id);
		m.addAttribute("declaration_num",declaration_num);
		declarationService.declarationPropertyDelete(m);
		declarationService.declarationDelete(declaration_num);
		return "success";
	}

}
