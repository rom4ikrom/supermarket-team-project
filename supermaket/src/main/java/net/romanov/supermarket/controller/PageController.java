package net.romanov.supermarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value = {"/", "/home" , "/index"})
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		mv.addObject("userClickHome", true);
		return mv;
		
	}
	
	@RequestMapping(value = {"/catalog"})
	public ModelAndView catalog() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Catalog");
		
		mv.addObject("userClickCatalog", true);
		return mv;
		
	}
	
	@RequestMapping(value = {"/about"})
	public ModelAndView about() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		
		mv.addObject("userClickAboutUs", true);
		return mv;
		
	}
	
	@RequestMapping(value = {"/login"})
	public ModelAndView login() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		
		mv.addObject("userClickAboutUs", true);
		return mv;
		
	}
	
	@RequestMapping(value = {"/basket"})
	public ModelAndView basket() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Basket");
		
		mv.addObject("userClickBasket", true);
		return mv;
		
	}

}
