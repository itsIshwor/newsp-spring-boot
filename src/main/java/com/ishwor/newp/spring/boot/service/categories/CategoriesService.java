package com.ishwor.newp.spring.boot.service.categories;

import java.util.List;

import com.ishwor.newp.spring.boot.domain.Categories;

public interface CategoriesService {
	public List<Categories> findAllCategories();

	public Categories findBycategoriesId(int id);

	public void addCategories(Categories categories);

	public void removeCategories(int id);
}
