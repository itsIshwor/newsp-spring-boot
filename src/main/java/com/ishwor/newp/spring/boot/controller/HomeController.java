package com.ishwor.newp.spring.boot.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ishwor.newp.spring.boot.comon.util.GlobalCategoriesModule;
import com.ishwor.newp.spring.boot.service.news.NewsServiceImpl;

@Controller
public class HomeController implements ErrorController {
	@Autowired
	GlobalCategoriesModule globalCategoriesModuleob;

	@Autowired
	NewsServiceImpl newServiceImpl;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "welCome | newsP");
		model.addAttribute("listAll", globalCategoriesModuleob.listAllCategories());
		// get all news and all it to the view
		model.addAttribute("allNews", newServiceImpl.findAllNewsDesc());
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