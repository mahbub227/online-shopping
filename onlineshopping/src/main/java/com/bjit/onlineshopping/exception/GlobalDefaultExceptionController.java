package com.bjit.onlineshopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionController {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle","Page Request is Invalid!");
		mv.addObject("errorDescription","Sorry, We'll construct it soon!");
		mv.addObject("title","404 Error Page");
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle","Product Not Found!");
		mv.addObject("errorDescription","Sorry, we'll add the product soon!");
		mv.addObject("title","Unavailable Product");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle","Contact Administrator please!");
		mv.addObject("errorDescription",ex.toString());
		mv.addObject("title","Error");
		return mv;
	}
}
