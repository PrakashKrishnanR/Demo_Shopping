package com.prad.OnlineShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.prad.ShoppingBackend.DAO.CategoryDAO;
import com.prad.ShoppingBackend.DTO.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	
	
	@RequestMapping(value = { "/", "/home", "/index" })

	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "home");
		mv.addObject("userClickHome", true);
		
		mv.addObject("categories", categoryDAO.list());
		return mv;
	}

	@RequestMapping(value = "/about")

	public ModelAndView about() {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value ="/contact")

	public ModelAndView contact() {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	/*
	 * Mapping to load all the products and category
	 * */
	@RequestMapping(value ="/show/all/products")

	public ModelAndView showAllProducts() {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "All Products");
		mv.addObject("userClickAllProduct", true);
		
		mv.addObject("categories", categoryDAO.list());
		return mv;
	}
	
	@RequestMapping(value ="/show/category/{id}/products")

	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		
		Category category = null;
		
		category = categoryDAO.get(id);

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", category.getName());
		
		//passing all products
		mv.addObject("categories", categoryDAO.list());

		//passing category
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProduct", true);
		
		return mv;
	}
	
}
