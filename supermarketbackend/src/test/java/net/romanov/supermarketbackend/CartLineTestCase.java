package net.romanov.supermarketbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.romanov.supermarketbackend.dao.CartLineDAO;
import net.romanov.supermarketbackend.dao.ProductDAO;
import net.romanov.supermarketbackend.dao.UserDAO;
import net.romanov.supermarketbackend.dto.Cart;
import net.romanov.supermarketbackend.dto.CartLine;
import net.romanov.supermarketbackend.dto.Product;
import net.romanov.supermarketbackend.dto.User;

public class CartLineTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CartLineDAO cartLineDAO = null;
	private static ProductDAO productDAO = null;
	private static UserDAO userDAO = null;
	
	private Product product = null;
	private User user = null;
	private Cart cart = null;
	private CartLine cartLine = null;
	
	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.romanov.supermarketbackend");
		context.refresh();

		productDAO = (ProductDAO) context.getBean("productDAO");
		userDAO = (UserDAO) context.getBean("userDAO");
		cartLineDAO = (CartLineDAO) context.getBean("cartLineDAO");

	}
	
	@Test
	public void testAddNewCartLine() {
		
		// getting the user
		user = userDAO.getByEmail("romanov@gmail.com");
		
		//fetch the cart
		cart = user.getCart();
		
		//get the product
		product = productDAO.get(3);
		
		//create a new cart line
		cartLine = new CartLine();
		
		cartLine.setBuyingPrice(product.getPrice());
		
		cartLine.setProductCount(cartLine.getProductCount() + 1);
		
		cartLine.setTotal(cartLine.getProductCount() * product.getPrice());
		
		cartLine.setAvailable(true);
		
		cartLine.setCartId(cart.getId());
		
		cartLine.setProduct(product);
		
		assertEquals("Fail to add the cartLine", true, cartLineDAO.add(cartLine));
		
		//update the cart
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() + 1);
		
		assertEquals("Fail to update the cart", true, cartLineDAO.updateCart(cart));
		
	}

}
