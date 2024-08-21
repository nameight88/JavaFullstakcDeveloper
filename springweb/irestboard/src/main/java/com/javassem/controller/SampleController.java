package com.javassem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.domain.SampleVO;

//@Controller+@ResponseBody
@RestController
public class SampleController {
	/*
	 * 스프링에서는 String 리턴값은 뷰페이지명으로 지정하는 것이다.
	 * @RsponseBody를 사용을 하면 문자열 값으로 인식을 한다.
	 */
	
	@RequestMapping(value="getText", produces="text/plain;charset=UTF-8")
	public String getText() {
		return "뷰페이지로 보냄";//-> /WEB-INF/views/+이름+.jsp
	}
	@RequestMapping("getObject")
	public SampleVO getObject() {
		SampleVO vo = new SampleVO("홍길동",22,"오늘도 화이팅");
		return vo;
	}
	@RequestMapping("/getLst")
	public List<SampleVO> getList() {
		List<SampleVO> list = new ArrayList<SampleVO>();
		list.add(new SampleVO("홍길동",22,"오늘도 화이팅"));
		list.add(new SampleVO("홍길자",33,"오늘 점심 뭐먹지"));
		list.add(new SampleVO("홍길숙",44,"우리팀 화이팅"));
		
		return list;
		
	}
	//@RequsetMapping = @GetMappin or @PostMapping 둘다 가능
	@GetMapping("/sample/{cate}/{cno}")
	public void getUrl(@PathVariable String cate,@PathVariable Integer cno) {
		System.out.println(cate+" : "+cno);
	}
	
	@PostMapping("sample/data")
	public SampleVO getPost(SampleVO vo) {
		System.out.println("확인: "+ vo.toString());
		return vo;
	}
}
