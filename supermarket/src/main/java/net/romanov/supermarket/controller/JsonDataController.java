package net.romanov.supermarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.romanov.supermarketbackend.dao.ProductDAO;
import net.romanov.supermarketbackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts() {
		return productDAO.listActiveProducts();
	}

}
