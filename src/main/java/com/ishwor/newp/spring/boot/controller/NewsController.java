package com.ishwor.newp.spring.boot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ishwor.newp.spring.boot.comon.util.GlobalCategoriesModule;
import com.ishwor.newp.spring.boot.comon.util.SaveMultipFile;
import com.ishwor.newp.spring.boot.comon.util.exception.DataNotFoundExeption;
import com.ishwor.newp.spring.boot.domain.Categories;
import com.ishwor.newp.spring.boot.domain.News;
import com.ishwor.newp.spring.boot.service.categories.CategoriesServiceImpl;
import com.ishwor.newp.spring.boot.service.doc.DocStorageService;
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

	@Autowired
	DocStorageService docStorageService;

	@Autowired
	SaveMultipFile multipleFile;

	@GetMapping("/news/create")
	public String createNews(@ModelAttribute("news") News news, BindingResult result, Model model) {

		model.addAttribute("title", "Create new News");

		List<Categories> listAll = categoriesServiceImpl.findAllCategories();

		model.addAttribute("listAll", listAll.toArray());
		return "/news/create-news";
	}

	@PostMapping("/news/save")
	public String saveNews(@ModelAttribute("news") News news, BindingResult result, Model model,
			@RequestParam("file") MultipartFile[] files) throws IOException, DataNotFoundExeption {
		multipleFile.SaveMultipleFile(files);
		model.addAttribute("title", "newsP|save news");
		log.info("=========File received=========\n\n\n");
		log.info("Number of file received::::" + files.length);

		Categories categories = news.getCategories();

		Categories categoriesToInsert = categoriesServiceImpl
				.findBycategoriesId(Integer.parseInt(categories.getCategoriesName()));

		news.setCategories(categoriesToInsert);

		newServiceImpl.saveNews(news);

		return "redirect:/news/list";
	}

	@GetMapping(path = "/news/list")
	public String listAllNews(Model model, @RequestParam(name = "page",defaultValue = "1") Integer pageNo) {

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
}
