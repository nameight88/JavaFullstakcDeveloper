package com.javaclass.basic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaclass.service.DeclarationService;
import com.javaclass.service.NewsService;
import com.javaclass.service.NoshowService;
import com.javaclass.service.ServiceTx;
import com.javaclass.vo.DeclarationVO;
import com.javaclass.vo.NewsVO;
import com.javaclass.vo.NoshowVO;

@Controller
@RequestMapping("manage")
public class ManageController {
	
	@Autowired
	private NewsService newsSerivce;
	
	@Autowired
	private DeclarationService declarationService;
	
	@Autowired
	private NoshowService noshowSerivce;
	
	@Autowired
	private ServiceTx service;
	
	//뉴스 관리 페이지로이동
	@RequestMapping("managerPage")
	public void  manager(Model model,@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
		List<NewsVO> newsList = newsSerivce.getNewsList(page,size);
		model.addAttribute("mainPage", newsList);
		int totalNews = newsSerivce.getTotalNewsCount();
		int totalPages = (int) Math.ceil((double) totalNews / size);
		model.addAttribute("newsList", newsList);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
	}
	//회원 노쇼 관련 페이지로 이동
	@RequestMapping("manageReservation")
	public void manageReservation(Model model,@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
		List<NoshowVO> noshowList = noshowSerivce.noshowGetList(page,size);
		int totalNoshow = noshowSerivce.getTotalNoshow();
		int totalPages = (int) Math.ceil((double) totalNoshow / size);
		model.addAttribute("noshowList",noshowList);
		
		model.addAttribute("manageReservation",noshowList);
		model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
	}
	
	//허위매물 신고 관리 페이지로 이동 
	@RequestMapping("managereport")
	public void manageReport(Model m,@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
		List<DeclarationVO> declarationList = 
				declarationService.getDeclarationList(page,size);
		int totalDeclaration = declarationService.getTotalDeclaration();
		int totalPages = (int) Math.ceil((double) totalDeclaration / size);
		
		m.addAttribute("declarationList", declarationList);
		m.addAttribute("currentPage", page);
        m.addAttribute("totalPages", totalPages);
	}
	
	@RequestMapping("userban")
	@ResponseBody
	public String userban(String user_id) {
		if(user_id != null) {
			service.userInfoDelete(user_id);
			return "success";
		}
		
		
		return "";		
	}
	
	

}
