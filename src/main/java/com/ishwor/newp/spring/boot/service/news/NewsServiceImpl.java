package com.ishwor.newp.spring.boot.service.news;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.ishwor.newp.spring.boot.comon.util.AOP.TrackQueryTime;
import com.ishwor.newp.spring.boot.comon.util.exception.DataNotFoundExeption;
import com.ishwor.newp.spring.boot.domain.News;
import com.ishwor.newp.spring.boot.repository.news.NewsRepo;

@Service
@Transactional
public class NewsServiceImpl {

	@Autowired
	NewsRepo newsRepo;

	@TrackQueryTime
	public Page<News> findAllNews(Integer pageNo, Integer pageSize) {

		Pageable paging = PageRequest.of(pageNo - 1, pageSize);

		Page<News> listOfNewsInPage = newsRepo.findAll(paging);

		return listOfNewsInPage;

	}

	@TrackQueryTime
	public News getNewsById(Integer id) throws DataNotFoundExeption {
		Optional<News> oneNews = newsRepo.findById(id);

		if (oneNews.isPresent())
			return oneNews.get();
		else
			throw new DataNotFoundExeption("No news can find with given id::" + id);
	}

	@TrackQueryTime
	public News saveNews(News news) throws DataNotFoundExeption {

		if (news.getId() == null)
			return newsRepo.save(news);

		Optional<News> isNewsPresent = newsRepo.findById(news.getId());

		if (isNewsPresent.isPresent()) {
			News newsToUpdate = isNewsPresent.get();
			newsToUpdate.setCategories(news.getCategories());
			newsToUpdate.setNewsBody(news.getNewsBody());
			newsToUpdate.setTitle(news.getTitle());
			newsToUpdate.setDocLocation(news.getDocLocation());
			newsToUpdate = newsRepo.save(newsToUpdate);
			return newsToUpdate;
		}
		return null;
	}

	@TrackQueryTime
	public void deleteNews(Integer id) throws DataNotFoundExeption {
		Optional<News> getNews = newsRepo.findById(id);

		if (getNews.isPresent())
			newsRepo.deleteById(id);
		else
			throw new DataNotFoundExeption("No News with id " + id + " can found.");
	}

	@TrackQueryTime
	@Query("select  n from News n where n.cId:=categoriesId")
	public News findNewsByCategories(int categoriesId) {
		return null;
	}
}
