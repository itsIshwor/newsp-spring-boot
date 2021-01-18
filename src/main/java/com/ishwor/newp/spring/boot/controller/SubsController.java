package com.ishwor.newp.spring.boot.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ishwor.newp.spring.boot.domain.Subscription;
import com.ishwor.newp.spring.boot.repository.subs.SubsRepoImp;

@Controller
public class SubsController {

	private static final Logger log = LoggerFactory.getLogger(SubsController.class);

	@Autowired
	SubsRepoImp subsRepoImp;

	@GetMapping("/subscribe")
	public String postEmailForSubscription(Model model, @ModelAttribute("subs") Subscription sub) {
		;
		model.addAttribute("title", "Subscribe NewsLater");
		return "subscribe";
	}

	@PostMapping("/subscribe-success")
	public String SubCribeSuccess(Model model, @Valid Subscription sub, Errors error) {
		log.info("Inside subsController POST Method");
		log.info("subs email:::::{}", sub.toString());

		if (error.hasErrors()) {
			model.addAttribute("error", error.getFieldValue("email"));
			
			log.info("error:::::: {}", error.getFieldValue("email"));
			
			log.info("\n\n{}", error.getAllErrors().toString());
			return "redirect:/subscribe";
		}

		subsRepoImp.save(sub);
		return "subscribe-success";
	}

}
