package com.ishwor.newp.spring.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ishwor.newp.spring.boot.comon.util.GlobalCategoriesModule;
import com.ishwor.newp.spring.boot.domain.Categories;
import com.ishwor.newp.spring.boot.domain.News;
import com.ishwor.newp.spring.boot.service.categories.CategoriesServiceImpl;
import com.ishwor.newp.spring.boot.service.news.NewsServiceImpl;

@Controller
public class NewsController {

	private static final Logger log = LoggerFactory.getLogger(NewsController.class);

	@Autowired
	CategoriesServiceImpl categoriesServiceImpl;

	@Autowired
	GlobalCategoriesModule globalCategoriesModuleob;

	@Autowired
	NewsServiceImpl newServiceImpl;

	@GetMapping("/news/create")
	public String createNews(@ModelAttribute("news") News news, BindingResult result, Model model) {

		model.addAttribute("title", "Create new News");

		List<Categories> listAll = categoriesServiceImpl.findAllCategories();

		model.addAttribute("listAll", listAll.toArray());
		return "/news/create-news";
	}

	@PostMapping("/news/save")
	public String saveNews(@ModelAttribute("news") News news, BindingResult result, Model model) {

		Categories categories = news.getCategories();

		Categories categoriesToInsert = categoriesServiceImpl
				.findBycategoriesId(Integer.parseInt(categories.getCategoriesName()));

		model.addAttribute("title", "newsP|save news");
		news.setCategories(categoriesToInsert);

		newServiceImpl.saveNews(news);

		return "redirect:/news/list";
	}

	@GetMapping(path = "/news/list")
	public String listAllNews(Model model) {

		Map<String, Object> attributes = new HashMap<>();
		attributes.put("title", "NewsP|news-list");
		attributes.put("allNews", newServiceImpl.findAllNews());
		attributes.put("listAll", globalCategoriesModuleob.listAllCategories());

		model.addAllAttributes(attributes);
		return "/news/list";
	}

	@GetMapping(path = "/news/update/{id}")
	public String updateNews(@PathVariable("id") Integer id, Model model) {

		Map<String, Object> attributes = new HashMap<>();

		attributes.put("title", "NewsP|news-update-" + id);
		attributes.put("news", newServiceImpl.findByNewsId(id));
		attributes.put("listAll", globalCategoriesModuleob.listAllCategories());

		model.addAllAttributes(attributes);

		return "/news/update";
	}

	@GetMapping(path = "/news/delete/{id}")
	public String deleteNews(@PathVariable("id") Integer id) {
		newServiceImpl.deleteNews(id);
		return "redirect:/news/list";
	}

	@GetMapping(path = "/news/view/{id}")
	public String viewIndividualNews(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("news", newServiceImpl.findByNewsId(id));
		model.addAttribute("title", "NewsP-News-" + id);
		log.info("views method browsed");
		return "/news/views";
	}
}
