package net.romanov.supermarket.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.romanov.supermarket.model.SupplierProductModel;
import net.romanov.supermarketbackend.dao.ProductDAO;
import net.romanov.supermarketbackend.dao.SupplierDAO;
import net.romanov.supermarketbackend.dto.Product;
import net.romanov.supermarketbackend.dto.Supplier;
import net.romanov.supermarketbackend.dto.SupplierOrderItem;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
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
	
	@RequestMapping("/admin/all/suppliers")
	@ResponseBody
	public List<Supplier> getAllSuppliersForAdmin() {
		return supplierDAO.listAll();
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
	
	@RequestMapping("/supply/all/products")
	@ResponseBody
	public List<SupplierProductModel> getAllSupplierProducts() {
		
		List<SupplierOrderItem> suppItems = supplierDAO.getAllSupplierProducts();
		
		List<SupplierProductModel> suppProductModelList = new ArrayList<>();
		
		if(suppItems != null) {
			
			for(SupplierOrderItem suppItem : suppItems) {
				
				Product product = productDAO.get(suppItem.getProductId());
				
				SupplierProductModel supProductModel = new SupplierProductModel();
				
				supProductModel.setName(product.getName());
				supProductModel.setVariety(product.getVariety());
				supProductModel.setQuantity(suppItem.getQuantity());
				supProductModel.setCountry(product.getCountry());
				
				Supplier supplier = supplierDAO.getById(suppItem.getSupplierId());
				
				supProductModel.setCompanyName(supplier.getCompanyName());
				supProductModel.setDate(suppItem.getSupOrderDate().toString());
				
				suppProductModelList.add(supProductModel);
			}
			
		}
		
		return suppProductModelList;
		
	}
	
	@RequestMapping("/supply/products")
	@ResponseBody
	public List<SupplierProductModel> getSupplierProductsBySupEmail() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		String email = auth.getName();
		
		Supplier supplier = supplierDAO.getByEmail(email);
		
		int id = supplier.getId();
		
		List<SupplierOrderItem> suppItems = supplierDAO.getSupplierProductsBySupId(id);
		
		List<SupplierProductModel> suppProductModelList = new ArrayList<>();
		
		if(suppItems != null) {
			for(SupplierOrderItem suppItem : suppItems) {
				
				Product product = productDAO.get(suppItem.getProductId());
				
				SupplierProductModel supProductModel = new SupplierProductModel();
				
				supProductModel.setName(product.getName());
				supProductModel.setVariety(product.getVariety());
				supProductModel.setQuantity(suppItem.getQuantity());
				supProductModel.setCountry(product.getCountry());
				
				supProductModel.setDate(suppItem.getSupOrderDate().toString());
				
				suppProductModelList.add(supProductModel);
			}
		}

		return suppProductModelList;
	}
	
}
