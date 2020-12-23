package com.ishwor.newp.spring.boot.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ishwor.newp.spring.boot.domain.Categories;
import com.ishwor.newp.spring.boot.service.categories.CategoriesSericeImpl;


@Controller()
public class CategoriesController {
	
	private static final Logger log = LogManager.getLogger(CategoriesController.class);	
	@Autowired
	CategoriesSericeImpl categoriesSericeImpl;

	@GetMapping("/categories/list")
	public String lisCategories(Model model) {
		
		model.addAttribute("title", "List-categories");
		List<Categories> listAll = categoriesSericeImpl.findAllCategories();
		
		model.addAttribute("listAll", listAll.toArray());
		log.info("List of All Available Categories====>\n {}",listAll);
		
		return "/categories/list-categories";
	}
	
	@GetMapping("/categories/add")
	public String createCategories(@ModelAttribute("categories") Categories categories,BindingResult result,Model model) {
		
		model.addAttribute("title", "add-categories");
		return "/categories/categories-create";
	}
	
	@PostMapping("/categories/save")
	public String saveCategories(@ModelAttribute("categories") Categories categories,BindingResult result) {
		
		categoriesSericeImpl.addCategories(categories);
		return "redirect:/categories/list";
	}
}
