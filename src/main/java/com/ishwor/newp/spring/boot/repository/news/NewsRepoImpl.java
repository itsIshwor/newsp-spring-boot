package com.ishwor.newp.spring.boot.repository.news;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ishwor.newp.spring.boot.domain.News;

@Repository
public class NewsRepoImpl implements NewsRepo {

	@Autowired
	EntityManager entityManager;

	@Override
	public void saveNews(News news) {

		Session session = entityManager.unwrap(Session.class);

		if (news.getId() == null)
			session.save(news);
		session.update(news);

	}

	@Override
	public void deleteNews(Integer id) {
		Session session = entityManager.unwrap(Session.class);
		News news = session.find(News.class, id);
		
		session.delete(news);

	}

	@Override
	public News findByNewsId(Integer id) {
		Session session = entityManager.unwrap(Session.class);
		return session.find(News.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> findAllNews() {
		Session session = entityManager.unwrap(Session.class);
		return session.getNamedNativeQuery("findAllNews").getResultList();
	}

}
