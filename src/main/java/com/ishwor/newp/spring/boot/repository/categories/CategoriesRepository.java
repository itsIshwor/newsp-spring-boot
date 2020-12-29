package com.ishwor.newp.spring.boot.repository.categories;

import java.util.List;

import com.ishwor.newp.spring.boot.domain.Categories;

public interface CategoriesRepository {
	public List<Categories> findAllCategories();

	public Categories findBycategoriesId(int id);

	public void addCategories(Categories categories);

	public void removeCategories(int id);

}
