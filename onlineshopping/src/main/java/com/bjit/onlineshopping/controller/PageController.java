package com.bjit.onlineshopping.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bjit.onlineshopping.exception.ProductNotFoundException;
import com.bjit.shoppingbackend.dao.CategoryDAO;
import com.bjit.shoppingbackend.dao.ProductDAO;
import com.bjit.shoppingbackend.dto.Category;
import com.bjit.shoppingbackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
 	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value= {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("title","Home");
		
		logger.info("Inside Page Controller Index Method==info");
		logger.debug("Inside Page Controller Index Method==debug");
	
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("userClickHome",true);
		return mv;
	}
	
	@RequestMapping(value= "/about")
	public ModelAndView about() {
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		return mv;
	}

	@RequestMapping(value= "/contact")
	public ModelAndView contact() {
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("title","Contact");
		mv.addObject("userClickContact",true);
		return mv;
	}
	
	
	@RequestMapping(value= "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("title","All Products");
	
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("userClickAllProducts",true);
		return mv;
	}
	
	@RequestMapping(value= "/show/category/{categoryId}/products")
	public ModelAndView showAllCategoryProducts(@PathVariable("categoryId") int categoryId) {
		ModelAndView mv= new ModelAndView("page");
		
		Category category=null;
		category=categoryDAO.get(categoryId);
		
		
		mv.addObject("title",category.getCategoryName());
	
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("category",category);
		
		mv.addObject("userClickCategoryProducts",true);
		return mv;
	}
	
	
	@RequestMapping(value= "/show/{productId}/product")
	public ModelAndView showSingleProduct(@PathVariable("productId") int productId) throws ProductNotFoundException{
		
		ModelAndView mv= new ModelAndView("page");
		Product product = productDAO.get(productId);
		if(product == null) throw new ProductNotFoundException();
		product.setViews(product.getViews()+1);
		productDAO.update(product);
		
		
		mv.addObject("title",product.getProductName());
		mv.addObject("product",product);
		mv.addObject("userClickShowProduct",true);
		
		return mv;
	}
	
	
	/*@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam(value="greeting", required=false)String greeting)
	{
		if(greeting==null) {
			greeting="Hello no greetig!";
		}
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("greeting",greeting);
		return mv;
	}
	
	@RequestMapping(value="/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting")String greeting)
	{
		if(greeting==null) {
			greeting="Hello no greetig!";
		}
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("greeting",greeting);
		return mv;
	}*/
}