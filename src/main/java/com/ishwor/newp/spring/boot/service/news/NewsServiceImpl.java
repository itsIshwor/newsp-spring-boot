package com.ishwor.newp.spring.boot.service.news;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ishwor.newp.spring.boot.domain.News;
import com.ishwor.newp.spring.boot.repository.news.NewsRepo;
import com.ishwor.newp.spring.boot.repository.news.NewsRepoImpl;

@Service
@Transactional
public class NewsServiceImpl implements NewsRepo {
	
	@Autowired
	NewsRepoImpl newsRepoImpl;

	@Override
	public void saveNews(News news) {
		newsRepoImpl.saveNews(news);
		
	}

	@Override
	public void deleteNews(Integer id) {
		newsRepoImpl.deleteNews(id);
		
	}

	@Override
	public News findByNewsId(Integer id) {
		return newsRepoImpl.findByNewsId(id);
		
	}

	@Override
	public List<News> findAllNews() {
		
		return newsRepoImpl.findAllNews();
	}

}
