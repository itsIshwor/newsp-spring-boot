package com.ishwor.newp.spring.boot.controller.simple;

import java.util.List;

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
import com.ishwor.newp.spring.boot.service.categories.CategoriesServiceImpl;


@Controller()
public class CategoriesController {

	@Autowired
	CategoriesServiceImpl categoriesServiceImpl;
	
	@Autowired
	GlobalCategoriesModule globalCategoriesModuleob;

	@GetMapping("/categories/list")
	public String lisCategories(Model model) {

		model.addAttribute("title", "List-categories");
		List<Categories> listAll = categoriesServiceImpl.findAllCategories();

		model.addAttribute("listAll", listAll.toArray());
		
		return "/categories/list-categories";
	}

	@GetMapping("/categories/add")
	public String createCategories(@ModelAttribute("categories") Categories categories, BindingResult result,
			Model model) {

		model.addAttribute("title", "add-categories");
		return "/categories/categories-create";
	}

	@PostMapping("/categories/save")
	public String saveCategories(@ModelAttribute("categories") Categories categories, BindingResult result) {

		categoriesServiceImpl.addCategories(categories);
		return "redirect:/categories/list";
	}

	
	
	@GetMapping("/categories/update/{id}")
	public String updateCategories(@PathVariable("id") int id, Model model) {
		model.addAttribute("title", "update categories-" + id);

		Categories categories = categoriesServiceImpl.findBycategoriesId(id);
		
		model.addAttribute("categories", categories);
		return "/categories/update-categories";
	}
	
	//view individual id
	@GetMapping("/categories/view/{id}")
	public String viewIndividual(@PathVariable("id") int id, Model model) {
		model.addAttribute("title", "view -" + id);

		model.addAttribute("listAll", globalCategoriesModuleob.listAllCategories());
		model.addAttribute("categories", categoriesServiceImpl.findBycategoriesId(id));
		return "/categories/individual-categories";
	}

	@GetMapping("/categories/delete/{id}")
	public String deleteCategories(@PathVariable("id") int id) {
		categoriesServiceImpl.removeCategories(id);
		return "redirect:/categories/list";
	}
}
