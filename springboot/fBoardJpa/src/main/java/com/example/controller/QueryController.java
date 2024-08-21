package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.persistence.QueryRepository;

@Controller
public class QueryController {
	
	@Autowired
	QueryRepository repo;
	
	@RequestMapping("query")
	public String queryTest(Model m) {
		
	List<Map> result =	repo.queryJpql("te");
	System.out.println(result);
	
	m.addAttribute("board",result);
	return "/board/getBoardList";
	}
}
