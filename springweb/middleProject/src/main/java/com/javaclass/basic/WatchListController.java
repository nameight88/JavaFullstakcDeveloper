package com.javaclass.basic;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaclass.service.WatchListService;
import com.javaclass.vo.WatchListVO;

@Controller
public class WatchListController {
	
	@Autowired
	private WatchListService watchListService;
	
	@RequestMapping("watchListInsert")
	@ResponseBody
	public String watchListInsert(int property_id, HttpSession session) {
		String user_id = (String) session.getAttribute("user");
		String agent_id = (String) session.getAttribute("agent");
		
		if(user_id != null) {
			HashMap map = new HashMap();
			map.putIfAbsent("property_id", property_id);
			map.putIfAbsent("user_id", user_id);
			
			Integer result = watchListService.watchListInsert(map);
			String result2 = String.valueOf(result);
			
			return result2;
			
			
		}else if(user_id == null & agent_id != null) { return "0"; }
		
		
		return "0";	
		
	}
	
	// 관심매물 삭제
	@RequestMapping("watchListDelete")
	@ResponseBody
	public String watchListDelete(int property_id, HttpSession session) {
		String user_id = (String) session.getAttribute("user");
		String agent_id = (String) session.getAttribute("agent");
		
		
		if(user_id != null) {
			WatchListVO vo = new WatchListVO();
			vo.setProperty_id(property_id);
			vo.setUser_id(user_id);
			
			int result = watchListService.watchListDelete(vo);
			String result2 = String.valueOf(result);
			
			return result2;
			
		}
		
		return "0";
	}

}
