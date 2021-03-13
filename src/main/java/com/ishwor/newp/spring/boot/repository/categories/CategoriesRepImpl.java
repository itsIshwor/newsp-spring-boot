package com.ishwor.newp.spring.boot.repository.categories;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ishwor.newp.spring.boot.comon.util.AOP.TrackQueryTime;
import com.ishwor.newp.spring.boot.domain.Categories;

@Repository
public class CategoriesRepImpl implements CategoriesRepository {

	@Autowired
	EntityManager sessionFactory;

	@Override
	@TrackQueryTime
	public List<Categories> findAllCategories() {
		Session session = sessionFactory.unwrap(Session.class);
	

		@SuppressWarnings("unchecked")
		List<Categories> result = session.getNamedQuery("findAllCategories").getResultList();
		return result;
	}

	@Override
	public Categories findBycategoriesId(int id) {
		Session session = sessionFactory.unwrap(Session.class);
		Categories categories = session.find(Categories.class, id);
		return categories;
	}

	@Override
	public void addCategories(Categories categories) {
		Session session = sessionFactory.unwrap(Session.class);

		if (categories.getcId() == null)
			session.save(categories);
		else
			session.update(categories);
	}

	@Override
	public void removeCategories(int id) {
		Session session = sessionFactory.unwrap(Session.class);
		Categories categories = session.find(Categories.class, id);
		session.delete(categories);
	}

}
