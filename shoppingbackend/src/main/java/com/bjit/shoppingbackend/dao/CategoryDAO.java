package com.bjit.shoppingbackend.dao;

import java.util.List;

import com.bjit.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	boolean add(Category category);
	
	List<Category>list();
	
	Category get(int id);

}
