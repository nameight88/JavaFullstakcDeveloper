package com.javaclass.basic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaclass.service.NewsService;
import com.javaclass.service.PropertyService;
import com.javaclass.service.ServiceTx;
import com.javaclass.service.WatchListService;
import com.javaclass.vo.AgentVO;
import com.javaclass.vo.NewsVO;
import com.javaclass.vo.PropertyOptionVO;
import com.javaclass.vo.PropertySecurityVO;
import com.javaclass.vo.PropertyVO;
import com.javaclass.vo.WatchListVO;

@Controller
public class IndexController {

	@Autowired
	private PropertyService propertyService;
	
	@Autowired
	private NewsService newsSerivce;
	
	@Autowired
	private ServiceTx service;
	
	@Autowired
	private WatchListService watchService;

	@RequestMapping("mainPage")
	public void mainPage(Model model,@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
		List<NewsVO> newsList = newsSerivce.getNewsList(page,size);
		int totalNews = newsSerivce.getTotalNewsCount();
		int totalPages = (int) Math.ceil((double) totalNews / size);
		model.addAttribute("newsList", newsList);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
		List<PropertyVO> newpropertyList = propertyService.getNewProperty();
		model.addAttribute("newpropertyList", newpropertyList);
	}
 
	@RequestMapping("ProductList")
	public String Category() {
		return "ProductList";
	}

	@RequestMapping("login")
	public String Login() {
		return "login";
	}

	@RequestMapping("map")
	public void map(PropertyVO vo, Model model, String searchText,
			@RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "pageSize", defaultValue = "3") int pageSize) {

		if (searchText == null) {
			String property_type = "전체";
			String property_cate = "전체";
			
			searchMap(property_type, property_cate, searchText, model, page, pageSize);
			
			
		}else {
			String property_type = "전체";
			String property_cate = "전체";
			
			searchMap(property_type, property_cate, searchText, model, page, pageSize);
			
		}
	
		
	}

	// 검색 기능
	@RequestMapping("searchMap")
	public String searchMap(String property_type, String property_cate, String searchText, Model model
							,@RequestParam(value = "page", defaultValue = "1") int page
							,@RequestParam(value = "pageSize", defaultValue = "3") int pageSize) {
		
		HashMap map = new HashMap();
		map.put("property_type", property_type);
		map.put("property_cate", property_cate);
		map.put("searchText", searchText);

		

		List<PropertyVO> result = propertyService.searchMap(map, page, pageSize);
		int totalCount = propertyService.getPropertiesCount(map);
		

		model.addAttribute("map", map);
		model.addAttribute("propertyList", result);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("page", page);
        model.addAttribute("pageSize", pageSize);

		return "map";

	}
	
	

	@RequestMapping("propertydetails")
	public String propertydetails(@RequestParam("property_id") int propertyId, Model model, HttpSession session) {
		Boolean result = false;

		String user_id = (String) session.getAttribute("user");
		Boolean watch = watchService.watchListproperty(user_id, propertyId);
		
		PropertyVO vo = propertyService.getProperty(propertyId);
		PropertyOptionVO optionVO = propertyService.getPropertyOption(propertyId);
		PropertySecurityVO securityVO = propertyService.getPropertySecurity(propertyId);
		AgentVO agentVO = service.agentSelect(vo.getAgent_id());
		
		
		model.addAttribute("property", vo);
		model.addAttribute("option", optionVO);
		model.addAttribute("security", securityVO);
		model.addAttribute("agent", agentVO);
		model.addAttribute("watch", watch);
		
	
		return "propertydetails";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session, HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:mainPage";
	}

}
