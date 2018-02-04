package com.bjit.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bjit.shoppingbackend.dao.CategoryDAO;
import com.bjit.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	private static List<Category>categories=new ArrayList<>();
	
	static {
		Category category=new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("Watch TV");
		category.setImageURL("image.png");
		categories.add(category);
		Category category2=new Category();
		category2.setId(2);
		category2.setName("Laptop");
		category2.setDescription("All Kinds of");
		category2.setImageURL("image1.png");
		categories.add(category2);
		Category category3=new Category();
		category3.setId(3);
		category3.setName("Mobile");
		category3.setDescription("Call friend");
		category3.setImageURL("image3.png");
		categories.add(category3);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		for(Category category : categories) {
			if(category.getId()==id) return category;
		}
		return null;
	}

}
