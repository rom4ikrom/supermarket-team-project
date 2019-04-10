package net.romanov.supermarket.controller;

import java.util.Date;
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
import net.romanov.supermarketbackend.dao.SupplierDAO;
import net.romanov.supermarketbackend.dto.Product;
import net.romanov.supermarketbackend.dto.Region;
import net.romanov.supermarketbackend.dto.Supplier;
import net.romanov.supermarketbackend.dto.SupplierOrderItem;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private RegionDAO regionDAO;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
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
			
			//add trigger to insert a new row to supplier_order_item table if quantity of product less than 5
			if(mProduct.getQuantity() < 3) {
				
				if(productDAO.getSupOrderItemByProductId(mProduct.getId()) == null) {
					
					SupplierOrderItem supOrderItem = new SupplierOrderItem();
					
					supOrderItem.setProductId(mProduct.getId());
					supOrderItem.setSupplierId(mProduct.getSupplierId());
					supOrderItem.setSupOrderDate(new Date());
					supOrderItem.setQuantity(7);
					
					productDAO.addSupOrderItem(supOrderItem);
				}

			}
			
			productDAO.add(mProduct);
		} else {
			
			//update the product if id is not 0
			productDAO.update(mProduct);
			
			Product updatedProduct = productDAO.get(mProduct.getId());
			
			if(updatedProduct.getQuantity() < 3) {

				if(productDAO.getSupOrderItemByProductId(updatedProduct.getId()) == null) {

					SupplierOrderItem supOrderItem = new SupplierOrderItem();

					supOrderItem.setProductId(updatedProduct.getId());
					supOrderItem.setSupplierId(updatedProduct.getSupplierId());
					supOrderItem.setSupOrderDate(new Date());
					supOrderItem.setQuantity(7);

					productDAO.addSupOrderItem(supOrderItem);
				}
				
				if(updatedProduct.getQuantity() < 1) {
					
					mProduct.setActive(false);
					productDAO.update(mProduct);
				}

			}
	
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
	
	//view manage suppliers page
	@RequestMapping(value = {"/suppliers"})
	public ModelAndView showManageSuppliers() {
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title", "SupplierManagement");
		mv.addObject("userClickManageSuppliers", true);
		
		return mv;
		
	}
	
	@ModelAttribute("regions")
	public List<Region> modelRegions() {
		return regionDAO.list();
	}
	
	@ModelAttribute("suppliers")
	public List<Supplier> modelSuppliers() {
		return supplierDAO.listActive();	
	}

}
