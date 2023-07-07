package com.restjpa.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(NullPointerException.class)
	public String nullPointerEceptionHandler(NullPointerException ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler(NoStudentFoundWithIdException.class)
	public String handleNoStudentFoundWithIdException(NoStudentFoundWithIdException ex) {
		return ex.getMessage();
	}
}
