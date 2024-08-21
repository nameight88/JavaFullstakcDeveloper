package com.javassem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("test")
public class TestController {

	@RequestMapping("getTest.do")
	public void getTest() {
		System.out.println("/getTest 요청 확인");
	}
}
