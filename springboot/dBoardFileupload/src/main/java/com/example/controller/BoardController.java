package com.example.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.BoardFileVO;
import com.example.domain.BoardVO;
import com.example.service.BoardService;
import com.example.util.MD5Generator;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@Controller
@RequestMapping("/board")
public class BoardController {

	static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardservice;

	// 글 등록하기
	@RequestMapping("/saveBoard")
	public String saveBoard(
			@RequestParam("file") MultipartFile files,
			BoardVO vo) {
		try {

			//파일의 원래 이름
			String originFilename = files.getOriginalFilename();
			System.out.println("원래 파일명: "+originFilename);

			//파일첨부를 한 경우라면
			if(originFilename != null && !originFilename.equals("")) {
				String filename = new MD5Generator(originFilename).toString();
				System.out.println("변경파일명: "+filename);
				/*
				 * [1] 추후 작업: 확장자가 필요하다면
				 * */


				//정해진 폴더를 지정
				String savepath = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\files";
				System.out.println("저장경로: "+savepath);
				/*
				 * [2]
				 * 
				 * */
				if( ! new File(savepath).exists()) {
					new File(savepath).mkdir();
				}
				//실제 저장되는 파일
				String filepath = savepath+"\\"+filename;
				files.transferTo(new File(filepath));
				System.out.println(filepath+"저장되었음");
				
				//디비저장
				BoardFileVO filevo = new BoardFileVO();
				filevo.setOriginFilename(originFilename);
				filevo.setFilename(filename);
				filevo.setFilepath(filepath);
				
				//파일을 첨부한 경우
				boardservice.saveBoard(vo, filevo);
			}// end of if
			else {
				//파일을 첨부하지 않은 경우
				boardservice.saveBoard(vo, null);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
//		boardservice.saveBoard(vo,null);
		logger.info("insert 결과");
		return "redirect:getBoardList";
	}//end of saveBoard

	// 글 삭제하기
	@RequestMapping("/deleteBoard")
	public String deleteBoard(
			BoardVO vo) {
		boardservice.deleteBoard(vo);
		return "redirect:getBoardList";
	}

	// 글 수정하기
	@RequestMapping("/updateBoard")
	public String updateBoard(BoardVO vo) {
		boardservice.getBoard(vo);
		return "board/getBoardList";
	}

	// 글 상세보기
	@RequestMapping("/getBoard") // getBoardList.jsp 파일 24행 
	public void getBoard(BoardVO vo, Model m) {
		HashMap result = boardservice.getBoard(vo);
//		System.out.println("----------------------------");
//		System.out.println(result);
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
