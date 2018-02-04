package com.bjit.shoppingbackend.dao;

import java.util.List;

import com.bjit.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	List<Category>list();
	
	Category get(int id);

}
