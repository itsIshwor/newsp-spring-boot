package com.ishwor.newp.spring.boot.controller;

import java.util.List;

import com.ishwor.newp.spring.boot.service.categories.CategoriesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ishwor.newp.spring.boot.domain.Categories;
import com.ishwor.newp.spring.boot.domain.News;
import com.ishwor.newp.spring.boot.service.news.NewsServiceImpl;

@Controller
public class NewsController {
	
	@Autowired
	CategoriesServiceImpl categoriesServiceImpl;
	
	@Autowired
	NewsServiceImpl newServiceImpl;


	@GetMapping("/news/create")
	public String createNews(@ModelAttribute("news") News news,BindingResult result, Model model) {
		
		model.addAttribute("title", "Create new News");
		
		List<Categories> listAll = categoriesServiceImpl.findAllCategories();

		model.addAttribute("listAll", listAll.toArray());
		return "/news/create-news";
	}
	
	@PostMapping("/news/save")
	public String saveNews(@ModelAttribute("news") News news, BindingResult result, Model model) {
		newServiceImpl.saveNews(news);
		
		model.addAttribute("title","save");
		
		return "/news/list";
	}
	
	@GetMapping(path = "/news/list")
	public String listAllNews() {
		
		return "/news/list";
	}
}
