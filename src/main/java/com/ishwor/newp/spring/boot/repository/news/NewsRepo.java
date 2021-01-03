package com.ishwor.newp.spring.boot.repository.news;

import java.util.List;

import com.ishwor.newp.spring.boot.domain.News;

public interface NewsRepo {
	public void saveNews(News news);
	
	public void deleteNews(Integer id);
	
	public News findByNewsId(Integer id);
	
	public List<News> findAllNews();
	
	public List<News> findAllNewsDesc();
}
