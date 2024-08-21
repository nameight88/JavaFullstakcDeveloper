package com.example.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceoptionHandler {
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception exception,Model m ) {
		
		m.addAttribute("exceoption",exception);
		return "/exception/GeneralExceoptionHandler";
	}
	// 추후에는 SQLException
	
	// 또는 Board/Member
	
}
