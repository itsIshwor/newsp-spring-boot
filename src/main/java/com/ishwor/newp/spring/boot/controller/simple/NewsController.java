package com.ishwor.newp.spring.boot.controller.simple;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ishwor.newp.spring.boot.comon.util.GlobalCategoriesModule;
import com.ishwor.newp.spring.boot.comon.util.exception.DataNotFoundExeption;
import com.ishwor.newp.spring.boot.domain.Categories;
import com.ishwor.newp.spring.boot.domain.News;
import com.ishwor.newp.spring.boot.service.categories.CategoriesServiceImpl;
import com.ishwor.newp.spring.boot.service.news.NewsServiceImpl;

@Controller
public class NewsController {

	private static final Logger log = LoggerFactory.getLogger(NewsController.class);

	@Autowired
	CategoriesServiceImpl categoriesServiceImpl;

	@Autowired
	GlobalCategoriesModule globalCategoriesModuleob;

	@Autowired
	NewsServiceImpl newServiceImpl;

	@GetMapping("/news/create")
	public String createNews(@ModelAttribute("news") News news, Model model) {

		model.addAttribute("title", "Create new News");

		List<Categories> listAll = categoriesServiceImpl.findAllCategories();

		model.addAttribute("listAll", listAll.toArray());
		return "/news/create-news";
	}

	@PostMapping("/news/save")
	public String saveNews(@ModelAttribute("news") News news, BindingResult result, Model model,
			@RequestParam("file") MultipartFile[] files) throws Exception {

		model.addAttribute("title", "newsP|save news");

		String[] fileLocations = new String[files.length];
		for (int i = 0; i < files.length; i++) {
			// create file Name to save at location
			String fileName = StringUtils.cleanPath(files[i].getOriginalFilename());
			fileLocations[i] = fileName;

		}
		// set images location for respective
		news.setDocLocation(fileLocations);
		Categories categories = news.getCategories();

		Categories categoriesToInsert = categoriesServiceImpl
				.findBycategoriesId(Integer.parseInt(categories.getCategoriesName()));

		news.setCategories(categoriesToInsert);

		News savedNews = newServiceImpl.saveNews(news);

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
		return "redirect:/news/list";
	}

	@GetMapping(path = "/news/list")
	public String listAllNews(Model model, @RequestParam(name = "page", defaultValue = "1") Integer pageNo) {

		int defaultPageSize = 3;

		Page<News> page = newServiceImpl.findAllNews(pageNo, defaultPageSize);
		List<News> allNews = page.getContent();

		Map<String, Object> attributes = new HashMap<>();
		attributes.put("title", "NewsP|news-list");
		attributes.put("allNews", allNews);
		attributes.put("totalElement", page.getTotalElements());
		attributes.put("totalPages", page.getTotalPages());
		attributes.put("listAll", globalCategoriesModuleob.listAllCategories());
		attributes.put("currentPage", pageNo);

		model.addAllAttributes(attributes);
		return "/news/list";
	}

	@GetMapping(path = "/news/update/{id}")
	public String updateNews(@PathVariable("id") Integer id, Model model) throws DataNotFoundExeption {

		Map<String, Object> attributes = new HashMap<>();

		attributes.put("title", "NewsP|news-update-" + id);
		attributes.put("news", newServiceImpl.getNewsById(id));
		attributes.put("listAll", globalCategoriesModuleob.listAllCategories());

		model.addAllAttributes(attributes);

		return "/news/update";
	}

	@GetMapping(path = "/news/delete/{id}")
	public String deleteNews(@PathVariable("id") Integer id) throws DataNotFoundExeption {

		// on delete news delete file associated with that news

		newServiceImpl.deleteNews(id);

		return "redirect:/news/list";
	}

	@GetMapping(path = "/news/view/{id}")
	public String viewIndividualNews(@PathVariable("id") Integer id, Model model) throws DataNotFoundExeption {
		model.addAttribute("news", newServiceImpl.getNewsById(id));
		model.addAttribute("title", "NewsP-News-" + id);
		log.info("views method browsed");
		return "/news/views";
	}

	@GetMapping(path = "/news/view/{catId}")
	public String findNewsByCategories() {
		return null;
	}
}
