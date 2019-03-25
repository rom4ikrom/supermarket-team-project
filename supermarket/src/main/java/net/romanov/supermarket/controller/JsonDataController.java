package net.romanov.supermarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.romanov.supermarketbackend.dao.ProductDAO;
import net.romanov.supermarketbackend.dao.UserDAO;
import net.romanov.supermarketbackend.dto.Product;
import net.romanov.supermarketbackend.dto.User;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts() {
		return productDAO.listActiveProducts();
	}
	
	@RequestMapping("/region/{id}/products")
	@ResponseBody
	public List<Product> getProductByRegion(@PathVariable int id) {
		return productDAO.listActiveProductsByRegionId(id);
	}
	
	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Product> getAllProductsForAdmin() {
		return productDAO.list();
	}
	
	@RequestMapping("/europe/mv/products")
	@ResponseBody
	public List<Product> getEuropeMostViewedProducts() {
		return productDAO.getProductsByRegion(4, 3);
	}
	
	@RequestMapping("/asia/mv/products")
	@ResponseBody
	public List<Product> getAsiaMostViewedProducts() {
		return productDAO.getProductsByRegion(3, 3);
	}
	
	@RequestMapping("/sa/mv/products")
	@ResponseBody
	public List<Product> getSAMostViewedProducts() {
		return productDAO.getProductsByRegion(7, 3);
	}
	
//	@RequestMapping("/user/personal")
//	@ResponseBody
//	public User getUserPersonalDetails() {
//		return userDAO.getUserInfo();
//	}
	

}
