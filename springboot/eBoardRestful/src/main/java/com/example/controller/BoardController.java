package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.BoardVO;
import com.example.service.BoardService;

import io.swagger.v3.oas.annotations.Operation;


@RestController // @Controller + @ResponseBody 라고 합쳐졌다고 쉽게 생각하자
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/board")
//@RequestMapping
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@GetMapping("/")
	public String test() {
		return "Restful 테스트 확인";
	}
	
	@PostMapping("/test2")
	public String test2() {
		return "Restful Post 요청 테스트 확인 ";
	}
	
	@Operation(summary="게시글 목록보기"
			,description="게시~글 목록~보기"
			,tags="[get] /board")
	@GetMapping(" ")
	public List<BoardVO> getBoardList(){
		BoardVO vo = new BoardVO();
		List<BoardVO> result = boardService.getBoardList(vo);
//		logger.info(result);
		return result;
	}
	
	@GetMapping("/{seq}")
	public BoardVO getBoard(@PathVariable Integer seq) {
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		BoardVO result = boardService.getBoard(vo);
//		logger.info(seq);
		return result;
	}
	
	@DeleteMapping("/{seq}")
	public void deleteBoard(@PathVariable Integer seq) {
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		boardService.deleteBoard(vo);
	}
	
	//입력 -> post
	@Operation(summary="게시글입력"
			,description="게시글에 사용자가 입력하면 저장"
			,tags= {"write","입력"})
	@PostMapping("/write")
	public String write(BoardVO vo) {
		boardService.saveBoard(vo);
//		logger.
		return "입력성공";
	}
	
	
	// 수정 - > put
	@Operation(summary = "게시글 수정"
			,description = "사용자가 작성한 글의 내용을 수정"
			,tags= {"update","수정"})
	@PutMapping("/{seq}")
	public String modify(@PathVariable Integer seq) {
		BoardVO vo = new BoardVO();
		boardService.getBoard(vo);
		return "수정 완료";
	}
}
