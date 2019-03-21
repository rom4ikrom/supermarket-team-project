package net.romanov.supermarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.romanov.supermarketbackend.dao.ProductDAO;
import net.romanov.supermarketbackend.dao.RegionDAO;
import net.romanov.supermarketbackend.dto.Product;
import net.romanov.supermarketbackend.dto.Region;

@Controller
public class PageController {
	
	private static Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private RegionDAO regionDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	//view home page
	@RequestMapping(value = {"/", "/home" , "/index"})
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");

		mv.addObject("userClickHome", true);
		return mv;

	}
	
	//view about us page
	@RequestMapping(value = {"/about"})
	public ModelAndView about() {
		
		logger.info("Inside PageController about method - INFO");
		logger.debug("Inside PageController about method - DEBUG");

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");

		mv.addObject("userClickAbout", true);
		return mv;

	}
	
	//view all products on product page
	@RequestMapping(value = {"/show/all/products"})
	public ModelAndView showAllProducts() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Catalog");

		//passing the list of regions
		mv.addObject("regions", regionDAO.list());

		mv.addObject("userClickAllProducts", true);
		return mv;

	}
	
	//view products for one specific region
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
	
	//view single product page
	@RequestMapping(value = {"/show/{id}/product"})
	public ModelAndView showSingleProduct(@PathVariable("id") int id) {
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		
		mv.addObject("title", product.getName() + " " + product.getVariety());
		mv.addObject("product", product);
		
		mv.addObject("userClickShowProduct", true);
		
		return mv;
		
	}
	
	//view user login page
	@RequestMapping(value = {"/login"})
	public ModelAndView login(@RequestParam(name="error", required = false) String error,
			@RequestParam(name="logout", required = false) String logout) {

		ModelAndView mv = new ModelAndView("customerLogin");
		
		if(error != null) {
			mv.addObject("message", "Invalid Username and Password!");
		}
		
		if(logout != null) {
			mv.addObject("logout", "User has successfully logout!");
		}
		
		mv.addObject("title", "Login");

		mv.addObject("userClickLogin", true);
		return mv;

	}
	
	// access denied
	@RequestMapping(value = "/access-denied")
	public ModelAndView accessDenied() {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title", "403 - Access Denied");
		mv.addObject("errorTitle", "Aha! Caught You.");
		mv.addObject("errorDescription", "You are not authorized to view this page");
		return mv;
		
	}
	
	//logout
	@RequestMapping(value="/perform-logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {

		//first we are going to fetch the authentication
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if(auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		return "redirect:/login?logout";
	}
	
	/*
	//view staff login page
	@RequestMapping(value = {"/admin/login"})
	public ModelAndView adminLogin() {

		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title", "Admin Login");

		mv.addObject("userClickAdminLogin", true);
		return mv;

	}
	*/
	
	
	//view create account page
	@RequestMapping(value = {"/create/account"})
	public ModelAndView createAccount() {

		ModelAndView mv = new ModelAndView("page");
		//mv.addObject("title", "Register");

		//mv.addObject("userClickRegister", true);
		return mv;

	}
	
	
	//view basket page
	@RequestMapping(value = {"/basket"})
	public ModelAndView basket() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Basket");

		mv.addObject("userClickBasket", true);
		return mv;

	}

}
