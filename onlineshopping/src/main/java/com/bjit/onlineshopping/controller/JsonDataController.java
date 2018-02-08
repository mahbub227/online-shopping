package com.bjit.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjit.shoppingbackend.dao.ProductDAO;
import com.bjit.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts(){
		
		return productDAO.listActiveProducts();
	
	}
	
	@RequestMapping("/category/{categoryId}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable("categoryId") int categoryId){
		
		return productDAO.listActiveProductsByCategory(categoryId);
	
	}
	
}
