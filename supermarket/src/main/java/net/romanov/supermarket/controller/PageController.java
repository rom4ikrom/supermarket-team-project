package net.romanov.supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.romanov.supermarketbackend.dao.RegionDAO;
import net.romanov.supermarketbackend.dto.Region;

@Controller
public class PageController {

	@Autowired
	private RegionDAO regionDAO;

	@RequestMapping(value = {"/", "/home" , "/index"})
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");

		mv.addObject("userClickHome", true);
		return mv;

	}

	@RequestMapping(value = {"/about"})
	public ModelAndView about() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");

		mv.addObject("userClickAbout", true);
		return mv;

	}

	@RequestMapping(value = {"/show/all/products"})
	public ModelAndView showAllProducts() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Catalog");

		//passing the list of regions
		mv.addObject("regions", regionDAO.list());

		mv.addObject("userClickAllProducts", true);
		return mv;

	}

	@RequestMapping(value = {"/show/region/{id}/products"})
	public ModelAndView showRegionProduct(@PathVariable("id") int id) {

		ModelAndView mv = new ModelAndView("page");

		Region region = null;

		region = regionDAO.get(id);

		mv.addObject("title", region.getName());

		//passing the list of regions
		mv.addObject("regions", regionDAO.list());

		//passing the single region object
		mv.addObject("region", region);

		mv.addObject("userClickRegionProducts", true);
		return mv;

	}

	@RequestMapping(value = {"/user/login"})
	public ModelAndView login() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Login");

		mv.addObject("userClickLogin", true);
		return mv;

	}

	@RequestMapping(value = {"/admin/login"})
	public ModelAndView adminLogin() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Admin Login");

		mv.addObject("userClickAdminLogin", true);
		return mv;

	}

	@RequestMapping(value = {"/create/account"})
	public ModelAndView createAccount() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Register");

		mv.addObject("userClickRegister", true);
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
