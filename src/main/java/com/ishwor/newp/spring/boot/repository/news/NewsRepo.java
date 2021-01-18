package com.ishwor.newp.spring.boot.repository.news;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ishwor.newp.spring.boot.domain.News;

@Repository
public interface NewsRepo extends JpaRepository<News, Integer> {
	/*
	 * public void saveNews(News news);
	 * 
	 * public void deleteNews(Integer id);
	 * 
	 * public News findByNewsId(Integer id);
	 * 
	 * public List<News> findAllNews();
	 * 
	 * public List<News> findAllNewsDesc();
	 */
}
