package net.romanov.supermarketbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.romanov.supermarketbackend.dao.ProductDAO;
import net.romanov.supermarketbackend.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.romanov.supermarketbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	/*
	@Test
	public void testCRUDproduct() {
		
		product = new Product();
		
		product.setName("Apple");
		product.setVariety("Golden");
		product.setDescription("This is Apple Golden from Ukraine.");
		
		product.setPrice(5);
		product.setQuantity(100);
		product.setActive(true);
		
		product.setCountry("Ukraine");
		product.setRegion(4);
		product.setPurchases(0);
		product.setViews(0);
		
		assertEquals("Something went wrong while inserting a new product!", true, productDAO.add(product));
		
		product = new Product();
		product.setName("Apple");
		product.setVariety("Golden");
		product.setDescription("This is Apple Golden from Ukraine.");
		
		product.setPrice(5);
		product.setQuantity(100);
		product.setActive(true);
		
		product.setCountry("Ukraine");
		product.setRegion(4);
		product.setPurchases(0);
		product.setViews(0);
		
		assertEquals("Something went wrong while inserting a new product!", true, productDAO.add(product));
		
		product = productDAO.get(2);
		product.setVariety("Gala");
		product.setDescription("This is Apple Gala from Poland.");
		
		product.setCountry("Poland");
		
		assertEquals("Something went wrong while updating a product!", true, productDAO.update(product));
		
		//assertEquals("Something went wrong while deleting a product!", true, productDAO.delete(product));
		
	}
	*/
	
	@Test
	public void testListActiveProducts() {
		assertEquals("Something went wrong while fetching the list of products!", 2, productDAO.listActiveProducts().size());
	}

}
