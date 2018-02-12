package com.bjit.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bjit.onlineshopping.util.FileUploadUtility;
import com.bjit.onlineshopping.validator.ProductValidator;
import com.bjit.shoppingbackend.dao.CategoryDAO;
import com.bjit.shoppingbackend.dao.ProductDAO;
import com.bjit.shoppingbackend.dto.Category;
import com.bjit.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired 
	private ProductDAO productDAO;
	
	private static final Logger logger =LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation",required=false)  String operation) {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Manage Products");
		mv.addObject("userClickManageProducts", true);
		Product nProduct = new Product();
		nProduct.setActive(true);
		mv.addObject("product", nProduct);
		
		if(operation!=null) {
			
			if(operation.equals("product")) {
				mv.addObject("message","New Product Added!");
			}
			else if(operation.equals("category")) {
				mv.addObject("message","New Category Added!");
			}
		}
		
		return mv;
	}
	
	
	
	@RequestMapping(value="/{productId}/product",method=RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int productId) {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Manage Products");
		mv.addObject("userClickManageProducts", true);
		Product product = productDAO.get(productId);
		mv.addObject("product", product);
		return mv;
	}
	
	
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category) {
		 categoryDAO.add(category);
		 return "redirect:/manage/products?operation=category";
	}
	
	
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product product,BindingResult results, Model model, HttpServletRequest request) {
		
		
		if(product.getProductId()==0) {
			new ProductValidator().validate(product,results);
		}
		else {
			if(!product.getFile().getOriginalFilename().equals("")) {
				new ProductValidator().validate(product,results);
			}
		}
	
	
		
		if(results.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title","Manage Products");
			return "page";
		}
		
		
		logger.info(product.toString());
		
		if(product.getProductId()==0) {
			productDAO.add(product);
		}
		else {

			productDAO.update(product);
		}
		
		if(!product.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, product.getFile(),product.getImage());
		}
		
		return "redirect:/manage/products?operation=product";
	}
	
	
	@RequestMapping(value = "/product/{productId}/activation", method=RequestMethod.GET)
	@ResponseBody
	public String managePostProductActivation(@PathVariable int productId) {		
		Product product = productDAO.get(productId);
		boolean isActive = product.isActive();
		product.setActive(!isActive);
		productDAO.update(product);		
		return (isActive)? "Product Dectivated Successfully!": "Product Activated Successfully";
	}
	
	
	
	@ModelAttribute("categories")
	public List<Category>getCategory(){
		return categoryDAO.list();
	}
	
	@ModelAttribute("category")
	public Category getCategoryName(){
		return new Category();
	}
	
}
