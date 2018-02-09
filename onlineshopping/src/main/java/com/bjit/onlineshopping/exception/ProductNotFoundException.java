package com.bjit.onlineshopping.exception;

import java.io.Serializable;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class ProductNotFoundException extends Exception implements Serializable{
	
	public static final long serialVersionUID = 1L;
	private String message;
	
	public ProductNotFoundException() {
		this("Sorry, the product is not available!");
	}
	
	public ProductNotFoundException(String message) {
		this.message = System.currentTimeMillis()+" : "+ message;
	}
	
	public String getMessage() {
		return message;
	}
	
	
	
	
}
