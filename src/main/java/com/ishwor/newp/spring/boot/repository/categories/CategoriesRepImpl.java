package com.ishwor.newp.spring.boot.repository.categories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ishwor.newp.spring.boot.domain.Categories;

@Repository
@Transactional
public class CategoriesRepImpl implements CategoriesRepository {

	@Autowired
	EntityManager sessionFactory;

	@Override
	
	public List<Categories> findAllCategories() {
		Session session = sessionFactory.unwrap(Session.class);
		
		@SuppressWarnings("unchecked")
		List<Categories> result = session.getNamedQuery("findAllCategories").getResultList();
		return result;
	}

	@Override
	public Categories findBycategoriesId(short id) {
		Session session = sessionFactory.unwrap(Session.class);
		Categories categories = session.find(Categories.class, id);
		return categories;
	}

	@Override
	public void addCategories(Categories categories) {
		Session session = sessionFactory.unwrap(Session.class);
		
		session.saveOrUpdate(categories);
	}

	@Override
	public void removeCategories(short id) {
		Session session = sessionFactory.unwrap(Session.class);
		Categories categories = session.find(Categories.class, id);
		session.delete(categories);
	}

}
