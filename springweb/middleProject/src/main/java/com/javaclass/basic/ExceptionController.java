package com.javaclass.basic;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.javaclass")
public class ExceptionController {
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception ex, Model m) {
		m.addAttribute("exception", ex);
		return"error/TransErrorPage";
	}
}
