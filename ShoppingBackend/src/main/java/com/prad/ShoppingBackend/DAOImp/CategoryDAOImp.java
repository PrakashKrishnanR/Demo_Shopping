package com.prad.ShoppingBackend.DAOImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.prad.ShoppingBackend.DAO.CategoryDAO;
import com.prad.ShoppingBackend.DTO.Category;

@Repository("categoryDAO")
public class CategoryDAOImp implements CategoryDAO {

	
	private static List<Category> categories = new ArrayList<>();
	
	static {
		//1st item
		Category category = new Category();
		
		category.setId(1);
		category.setName("Mobile");
		category.setDescription("This is a description for Mobile");
		category.setImageurl("CAT_1");
		
		categories.add(category);
		
		//2nd Item
		category = new Category();
		
		category.setId(2);
		category.setName("Telivision");
		category.setDescription("This is a description for Telivision");
		category.setImageurl("CAT_2");
		
		categories.add(category);
		
		//3rd Item
		category = new Category();
		
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is a description for Laptop");
		category.setImageurl("CAT_3");
		
		categories.add(category);
		
		
	}
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}
	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		for(Category c:categories) {
			if(c.getId() == id) return c;
		}
		return null;
	}
	
	

}
