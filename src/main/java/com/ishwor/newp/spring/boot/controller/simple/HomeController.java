package com.ishwor.newp.spring.boot.controller.simple;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ishwor.newp.spring.boot.comon.util.GlobalCategoriesModule;
import com.ishwor.newp.spring.boot.domain.News;
import com.ishwor.newp.spring.boot.domain.Subscription;
import com.ishwor.newp.spring.boot.service.news.NewsServiceImpl;

@Controller
public class HomeController implements ErrorController {
	@Autowired
	GlobalCategoriesModule globalCategoriesModuleob;

	@Autowired
	NewsServiceImpl newServiceImpl;

	@GetMapping("/")
	public String home(Model model, @ModelAttribute("subs") Subscription subs,
			@RequestParam(name = "page", defaultValue = "1") Integer pageNo) {
		model.addAttribute("title", "welCome | newsP");
		model.addAttribute("listAll", globalCategoriesModuleob.listAllCategories());

		int defaultPageSize = 5;

		Page<News> page = newServiceImpl.findAllNews(pageNo, defaultPageSize);
		List<News> allNews = page.getContent();
		// get all news and all it to the view
		model.addAttribute("allNews", allNews);

		model.addAttribute("totalElement", page.getTotalElements());
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("currentPage", pageNo);

		return "index";
	}

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request, Model model) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

		if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());

			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				return "error-404";
			} else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return "error-500";
			}
		}
//		model.addAttribute("code", status);
		return "error";
	}

	@Override
	public String getErrorPath() {

		return "error";
	}
}