package com.ishwor.newp.spring.boot.comon.util;

import java.util.List;

import com.ishwor.newp.spring.boot.service.categories.CategoriesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ishwor.newp.spring.boot.domain.Categories;



@Component
public class GlobalCategoriesModule {
	@Autowired
	CategoriesServiceImpl categoriesServiceImpl;

	@ModelAttribute("listAll")
	public List<Categories> listAllCategories() {
		List<Categories> listAll = categoriesServiceImpl.findAllCategories();
		
		return listAll;
	}
}
