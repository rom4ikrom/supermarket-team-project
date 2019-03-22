package net.romanov.supermarket.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.romanov.supermarket.util.FileUploadUtility;
import net.romanov.supermarket.validator.ProductValidator;
import net.romanov.supermarketbackend.dao.ProductDAO;
import net.romanov.supermarketbackend.dao.RegionDAO;
import net.romanov.supermarketbackend.dto.Product;
import net.romanov.supermarketbackend.dto.Region;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private RegionDAO regionDAO;
	
	//view manage products page
	@RequestMapping(value = {"/products"}, method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation", required=false) String operation) {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Product Management");
		mv.addObject("userClickManageProducts", true);
		
		Product nProduct = new Product();
		
		nProduct.setActive(true);
		
		mv.addObject("product", nProduct);
		
		if(operation != null) {
			if(operation.equals("product")) {
				mv.addObject("message", "Product Submitted Successfully!");
			}
		}
		
		return mv;
		
	}
	
	//view manage product page by product id
	@RequestMapping(value="/{id}/product", method = RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int id) {
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title", "Product Management");
		mv.addObject("userClickManageProducts", true);
		
		//fetch the product from database
		Product product = productDAO.get(id);
		
		mv.addObject("product", product);
		
		return mv;
		
	}
	
	//handling product submission
	@RequestMapping(value={"/products"}, method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct,
			BindingResult results, Model model, HttpServletRequest request) {
		
		//handle image validation for new products
		if(mProduct.getId() == 0) {
			new ProductValidator().validate(mProduct, results);
		} else {
			if(!mProduct.getFile().getOriginalFilename().equals("")) {
				new ProductValidator().validate(mProduct, results);
			}
		}
		
		//check if there are any errors
		if(results.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Product Management");
			model.addAttribute("message", "Validation failed for Product Submission!");
			model.addAttribute("status", false);
			return "page";
		}
		
		logger.info(mProduct.toString());
		
		if(mProduct.getId() == 0) {
			//create a new product record if id is 0
			productDAO.add(mProduct);
		} else {
			//update the product if id is not 0
			productDAO.update(mProduct);
		}
		
		if(!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
	}
	
	@RequestMapping(value= {"/product/{id}/activation"}, method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {
		
		//fetch the product from the database
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		
		//activating and deactivating based on the value of active field
		product.setActive(!product.isActive());
		
		//updating the product
		productDAO.update(product);
		
		return (isActive)? "You have sussesfully deactivated the product with id " + product.getId():
			"You have sussesfully activated the product with id " + product.getId();
	}
	
	@ModelAttribute("regions")
	public List<Region> modelRegions() {
		return regionDAO.list();
	}

}
