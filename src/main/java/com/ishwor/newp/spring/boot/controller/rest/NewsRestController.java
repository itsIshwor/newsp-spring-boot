package com.ishwor.newp.spring.boot.controller.rest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ishwor.newp.spring.boot.comon.util.exception.DataNotFoundExeption;
import com.ishwor.newp.spring.boot.domain.News;
import com.ishwor.newp.spring.boot.service.news.NewsServiceImpl;

@RestController
public class NewsRestController {
	@Autowired
	NewsServiceImpl newsServiceImpl;

	@GetMapping(path = "/rest/news")
	@ResponseBody
	public List<News> allNews(@RequestParam("size") Integer pageSize, @RequestParam("pageNo") Integer pageNo) {

		Page<News> page = newsServiceImpl.findAllNews(pageNo, pageSize);
		List<News> allNews = page.getContent();

		return allNews;
	}

	@ResponseBody
	@PostMapping(path = "/rest/news")
	public News addNews(@RequestBody News news, MultipartFile[] files) throws DataNotFoundExeption, IOException {

		String[] fileLocations = new String[files.length];
		for (int i = 0; i < files.length; i++) {
			// create file Name to save at location
			String fileName = StringUtils.cleanPath(files[i].getOriginalFilename());
			fileLocations[i] = fileName;

		}

		News savedNews = newsServiceImpl.saveNews(news);

		// create directory for the files with news id and file Name
		for (int i = 0; i < files.length; i++) {
			String locationToDb = new File("./src/main/webapp/resources/doc-dir/" + savedNews.getNews_id() + "/"
					+ files[i].getOriginalFilename()).getAbsolutePath();

			Path uploadPath = Paths.get(locationToDb);

			if (!Files.exists(uploadPath))
				Files.createDirectories(uploadPath);

			try (InputStream inputStream = files[i].getInputStream()) {
				Path filePath = uploadPath.resolve(locationToDb);

				Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				throw new IOException("Could not save file to upload" + files[i]);
			}
		}
		return savedNews;

	}
}
