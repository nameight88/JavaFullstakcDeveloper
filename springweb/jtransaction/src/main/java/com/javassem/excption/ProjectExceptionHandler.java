package com.javassem.excption;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.javassem")
public class ProjectExceptionHandler {
	
	/*
	 * 추후에는 구체적인 예외를 처리
	 *  Ex) BoardException, MemberException
	 *  카테고리 별로 만들어주는게 좋다.
	 * 
	 */
	
	@ExceptionHandler(Exception.class)
	public String handleExceprion(Exception ex,Model m) {
		m.addAttribute("exception",ex);
		return "error/TransErrorPage";
	}
}
