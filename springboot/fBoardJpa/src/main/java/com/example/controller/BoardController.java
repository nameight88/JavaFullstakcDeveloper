package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.BoardVO;
import com.example.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardservice;
	
	// 글 등록하기
	@RequestMapping("/saveBoard")
	public String saveBoard(BoardVO vo) {
		boardservice.saveBoard(vo);
		return "redirect:getBoardList";
	}
	
	// 글 삭제하기
	@RequestMapping("/deleteBoard")
	public String deleteBoard(BoardVO vo) {
		boardservice.deleteBoard(vo);
		return "redirect:getBoardList";
	}
	
	// 글 수정하기
	@RequestMapping("/updateBoard")
	public String updateBoard(BoardVO vo) {
		boardservice.getBoard(vo);
		return "redirect:getBoardList";
	}
	
	// 글 상세보기
	@RequestMapping("/getBoard") // getBoardList.jsp 파일 24행 
	public void getBoard(BoardVO vo, Model m) {
		BoardVO result = boardservice.getBoard(vo);
		m.addAttribute("board", result); // getBoard.jsp에 받는 이름과 동일하게
	}
	
	// 글 목록 보기
	// Model return
	@RequestMapping("/getBoardList")
	public void getBoardList(Model m) {
		BoardVO vo = new BoardVO(); // 추후에 조건 검색
		List<BoardVO> list = boardservice.getBoardList(vo);
		m.addAttribute("boardList", list); // getBoardList.jsp 파일 21행 items와 같게 
	}
	
	
	@RequestMapping("/{step}")
	public String viewPage(@PathVariable String step) { // 경로변수 지정: @PathVariable
		logger.info(step + "경로 들어옴");
		return "board/"+step;
	}
	
	@RequestMapping("/test")
	public void test() {
		System.out.println("/board/test 요청");
		
		// JSP 뷰페이지 지정
		// wepapp/WEB-INF/views + /board/test.jsp
	}
}
