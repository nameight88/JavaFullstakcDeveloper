package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.BoardVO;
import com.example.persistence.PagingRepository;

@Controller
public class PagingController {
	
	@Autowired
	PagingRepository repo;
	@RequestMapping("/paging")
	public String paging(Model m) {
		//paging (페이지번호,몇개의 레코드)
		// ---- 인덱스는 0부터
		Pageable paging = PageRequest.of(1,3);
		
		List<BoardVO> result = repo.findAll(paging);
		m.addAttribute("boardList", result);
		
		return "/board/getBoardList";
	}
}
