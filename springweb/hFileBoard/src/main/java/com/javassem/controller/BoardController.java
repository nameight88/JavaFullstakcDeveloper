package com.javassem.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javassem.domain.BoardVO;
import com.javassem.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

		@RequestMapping("/{step}.do")
		public String viewPage(@PathVariable String step) {
			return step;
		}
	
		// 글 목록 검색
		@RequestMapping("/getBoardList.do")
		public void getBoardList(BoardVO vo, Model model) {
				List<BoardVO> result = boardService.getBoardList(vo);
				
				model.addAttribute("boardList", result);
				
		}
	
		// 글 등록
		@RequestMapping(value = "/saveBoard.do")
		public String insertBoard(BoardVO vo) throws IOException {
				
			boardService.insertBoard(vo);
			return "redirect:getBoardList.do";
		}

		// 글 수정
		@RequestMapping("/updateBoard.do")
		public void updateBoard(BoardVO vo) {

			
		}

		// 글 삭제
		@RequestMapping("/deleteBoard.do")
		public void deleteBoard(BoardVO vo) {

			
		}

		// 글 상세 조회
		@RequestMapping("/getBoard.do")
		public void getBoard(BoardVO vo, Model model) {
			BoardVO result =boardService.getBoard(vo);
			model.addAttribute("board", result);
		}

	}
