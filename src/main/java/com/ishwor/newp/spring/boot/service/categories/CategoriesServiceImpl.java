package com.ishwor.newp.spring.boot.service.categories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ishwor.newp.spring.boot.comon.util.AOP.TrackQueryTime;
import com.ishwor.newp.spring.boot.domain.Categories;
import com.ishwor.newp.spring.boot.repository.categories.CategoriesRepImpl;

@Service
@Transactional
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
	public CategoriesRepImpl categoriesRepImpl;

	@Override
	@TrackQueryTime
	public List<Categories> findAllCategories() {

		return categoriesRepImpl.findAllCategories();
	}

	@Override
	@TrackQueryTime
	public Categories findBycategoriesId(int id) {

		return categoriesRepImpl.findBycategoriesId(id);
	}

	@Override
	@TrackQueryTime
	public void addCategories(Categories categories) {
		categoriesRepImpl.addCategories(categories);

	}

	@Override
	@TrackQueryTime
	public void removeCategories(int id) {
		categoriesRepImpl.removeCategories(id);

	}

}
