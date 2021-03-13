package com.ishwor.newp.spring.boot.controller.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ishwor.newp.spring.boot.comon.util.exception.DataNotFoundExeption;
import com.ishwor.newp.spring.boot.domain.News;
import com.ishwor.newp.spring.boot.service.news.NewsServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
public class HomeRestController {

	private static final Logger log = LoggerFactory.getLogger(HomeRestController.class);

	@Autowired
	NewsServiceImpl newsServiceImpl;

	@GetMapping(path = "/rest")
	@ApiOperation(response = News.class, httpMethod = "GET", notes = "This page will reurn  news taking page no and pasize ans parameter for pagination", value = "all news with in pagination limit")
	@ResponseBody
	public List<News> allNews(@RequestParam("size") Integer pageSize, @RequestParam("pageNo") Integer pageNo,
			HttpServletResponse res) {
		List<News> allNews = null;
		try {
			Page<News> page = newsServiceImpl.findAllNews(pageNo, pageSize);

			allNews = page.getContent();
			if (allNews.size() == 0) {
				throw new DataNotFoundExeption("News Doesn't exists");
			}

			log.info("{}", page.getContent());

		} catch (DataNotFoundExeption exe) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, exe.getMessage());
		}
		return allNews;
	}
}
