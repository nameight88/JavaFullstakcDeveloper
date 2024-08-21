package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.BoardVO;
import com.example.persistence.SampleRepository;

@Controller
public class SampleController {
	@Autowired
	private SampleRepository repo;
	
	@RequestMapping("/sample")
	public String sample(Model m) {
		
//		List<BoardVO> result = repo.findByTitle("222");
//		List<BoardVO> result = repo.findByTitleNot("222");
//		List<BoardVO> result = repo.findByTitleOrWriter("test", "홍길동");
//		List<BoardVO> result = repo.findByTitleContaining("test");
		List<BoardVO> result = repo.findByTitleContainingOrderByTitleDesc("test");
		
		m.addAttribute("boardList", result);
		return "/board/getBoardList";
	}
	
}
