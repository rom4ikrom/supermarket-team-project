package net.romanov.supermarket.controller;

import java.util.List;

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

import net.romanov.supermarket.exception.ProductNotFoundException;
import net.romanov.supermarketbackend.dao.CartLineDAO;
import net.romanov.supermarketbackend.dao.ProductDAO;
import net.romanov.supermarketbackend.dao.RegionDAO;
import net.romanov.supermarketbackend.dao.SupplierDAO;
import net.romanov.supermarketbackend.dao.UserDAO;
import net.romanov.supermarketbackend.dto.Address;
import net.romanov.supermarketbackend.dto.OrderDetail;
import net.romanov.supermarketbackend.dto.Product;
import net.romanov.supermarketbackend.dto.Region;
import net.romanov.supermarketbackend.dto.Supplier;
import net.romanov.supermarketbackend.dto.User;

@Controller
public class PageController {
	
	private static Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private RegionDAO regionDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
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

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");

		mv.addObject("userClickAbout", true);
		return mv;

	}
	
	//view about us page
	@RequestMapping(value = {"/contact"})
	public ModelAndView contact() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");

		mv.addObject("userClickContact", true);
		return mv;

	}

	//view about us page
	@RequestMapping(value = {"/help"})
	public ModelAndView help() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");

		mv.addObject("userClickHelp", true);
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
	public ModelAndView showSingleProduct(@PathVariable("id") int id) throws ProductNotFoundException {
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		if(product == null) throw new ProductNotFoundException();
		
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
	
	//account pages
	private static String getUserByEmail() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		String email = auth.getName();
		
		return email;
		
	}
	
	//account personal
	@RequestMapping(value="account/personal")
	public ModelAndView showAccountPersonal() {
		
		ModelAndView mv = new ModelAndView("page");
		
		String email = getUserByEmail();
		
		User user = userDAO.getByEmail(email);
		
		if(user != null) {
			mv.addObject("user", user);
		}
		
		Supplier supplier = supplierDAO.getByEmail(email);
		
		if(supplier != null) {
			mv.addObject("user", supplier);
		}
		
		mv.addObject("title", "Account Personal");
		mv.addObject("userClickAccountPersonal", true);
		
		return mv;
		
	}
	
	//account address
	@RequestMapping(value="account/address")
	public ModelAndView showAccountAddress() {
		
		ModelAndView mv = new ModelAndView("page");
		
		String email = getUserByEmail();
		
		if(userDAO.getByEmail(email) != null) {
			
			int userId = userDAO.getByEmail(email).getId();
			
			Address billing = userDAO.getBilling(userId);
			
			List<Address> shipping = userDAO.listShippingAddresses(userId);
			
			mv.addObject("billing", billing);
			mv.addObject("listShipping", shipping);
		}
		
		mv.addObject("title", "Account Address");
		mv.addObject("userClickAccountAddress", true);
		
		return mv;
		
	}
	
	//account orders
	@RequestMapping(value="account/orders")
	public ModelAndView showAccountOrders() {
		
		ModelAndView mv = new ModelAndView("page");
		
		String email = getUserByEmail();
		
		int userId = userDAO.getByEmail(email).getId();
		
		List<OrderDetail> orderDetails = cartLineDAO.listOrderDetailsByUserId(userId);
		
		mv.addObject("orderDetails", orderDetails);
		//mv.addObject("orderItems", orderItems);
		
		mv.addObject("title", "Account Orders");
		mv.addObject("userClickAccountOrders", true);
		
		return mv;
		
	}
	
	
	//view staff login page
	@RequestMapping(value = {"/admin/login"})
	public ModelAndView adminLogin() {

		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title", "Admin Login");

		mv.addObject("userClickAdminLogin", true);
		return mv;

	}
	

}
