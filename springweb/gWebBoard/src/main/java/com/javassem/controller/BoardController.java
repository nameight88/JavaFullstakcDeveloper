package com.javassem.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javassem.domain.BoardVO;
import com.javassem.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/getBoardList.do")
	public void getBoardList(String searchCondition, String searchKeyword,Model m) {
		//System.out.println(searchCondition.toString()+searchKeyword.toString());
		HashMap map = new HashMap();
		map.put("searchCondition", searchCondition);
		map.put("searchKeyword", searchKeyword);
		
		//System.out.println("getBoardList.do 연결");
		List<BoardVO> list = boardService.getBoardList(map);
		m.addAttribute("boardList",list);
	}
	
	@RequestMapping("/insertBoard.do")
	public void insertBoard() {
		System.out.println("insertBoard.do 연결");	
		
	}
	
	@RequestMapping("/saveBoard.do")
	public String saveBoard(BoardVO vo) {
		System.out.println("saveBoard.do 연결");
		System.out.println(vo.toString());
		
		boardService.insertBoard(vo);
		
		// -> 단순 string으로 바꾸면 url은 그대로에 페이지가 덫붙여진다
		// -> redirect 사용시 url도 바뀌면서 페이지가 해당 경로의 화면으로 바뀜
		
		
		// http://localhost:8080/gWebBoard/board/saveBoard.do
		//return "getBoardList";	// 뷰 페이지 지정 getBoardList.jsp
		
		// 목록보기 요청을다시 -> List<BoardVO> list 얘가 있어야 하기 때문에
		// http://localhost:8080/gWebBoard/board/getBoardList.do
		return "redirect:getBoardList.do"; 

	}
	@RequestMapping("getBoard.do")
	public void getBoard(BoardVO vo,Model m) {
//		System.out.println("getBoard 요청확인");
//		System.out.println("넘어오는 값 확인:"+vo.toString());
		BoardVO result = boardService.getBoard(vo);
		m.addAttribute("board",result);
	}
	
	@RequestMapping("updateBoard.do")
	public String updateBoard(BoardVO vo) {
		System.out.println("updateBoard 요청 확인"+"/"+vo.toString());
		boardService.updateBoard(vo);
		return "redirect:getBoardList.do"; 
	}
	
	@RequestMapping("deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("deleteBoard 요청 확인"+"/"+vo.toString());
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do"; 
	}
	

}
