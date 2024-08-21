package com.javassem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.domain.ReplyVO;
import com.javassem.service.ReplyService;

@RestController
public class ReplyController {
	
	@Autowired
	ReplyService replyService;
	
	@PostMapping("replies/new")
	public String insert(ReplyVO vo) {
		System.out.println(vo.toString());
		Integer result = replyService.insertReply(vo);
		if(result ==1) return "success";
		else return "fail";
		
	}
	@GetMapping("replies")
	public List<ReplyVO> selectAll(Integer bno) {
//		List<ReplyVO> list = new ArrayList<ReplyVO>();
//		for(int i=0;i<3;i+=1) {
//			ReplyVO vo = new ReplyVO();
//			vo.setBno(i);
//			vo.setReplyer("홍길동"+i);
//			vo.setReply("댓글"+i);
//			list.add(vo);
//		}
		System.out.println("게시글 번호: "+bno);
		List<ReplyVO> list = replyService.selectAllReply(bno);
		return list;
	}
	
	/*
	 *  json-simple.jar 라이브러리 사용시 객체 전송이 안되어서
	 * 
	 *  JSON 구조를 문자열로 변경해서 전송해야 함
	 * 
	 *  stringify() 함수를 이용을 함
	 * 
	 */
	
	
	
	@DeleteMapping("replies/{rno}")
	public Integer delete(@PathVariable Integer rno) {
		System.out.println("삭제할 댓글번호: "+rno);
		return replyService.deleteReply(rno);
	}
	
	@PostMapping("replies/{rno}")
	public void modify(@PathVariable Integer rno, ReplyVO vo) {
		System.out.println(rno+" : "+vo.toString());
	}
}
