package net.romanov.supermarket.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.romanov.supermarket.model.UserModel;
import net.romanov.supermarketbackend.dao.CartLineDAO;
import net.romanov.supermarketbackend.dao.ProductDAO;
import net.romanov.supermarketbackend.dto.Cart;
import net.romanov.supermarketbackend.dto.CartLine;
import net.romanov.supermarketbackend.dto.Product;

@Service("cartService")
public class CartService {
	
	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private HttpSession session;
	
	//return the cart of the user who has logged in
	private Cart getCart() {
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}
	
	//return the entire cart lines
	public List<CartLine> getCartLines() {
		return cartLineDAO.list(this.getCart().getId());
	}
	
	public String manageCartLine(int cartLineId, int count) {
		
		//fetch the cartline
		CartLine cartLine = cartLineDAO.get(cartLineId);
		
		if(cartLine == null) {
			return "result=error";
		} else {
			
			Product product = cartLine.getProduct();
			
			double oldTotal = cartLine.getTotal();
			
			//checking if the product is available
			if(product.getQuantity() < count) {
				return "result=unavailable";
			}
			
			cartLine.setProductCount(count);
			cartLine.setBuyingPrice(product.getPrice());
			cartLine.setTotal(product.getPrice() * count);
			
			cartLineDAO.update(cartLine);
			
			Cart cart = this.getCart();
			
			cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
			
			cartLineDAO.updateCart(cart);
			
			return "result=updated";
			
		}
	}
	
	public String deleteCartLine(int cartLineId) {
		
		//fetch the cart line
		CartLine cartLine = cartLineDAO.get(cartLineId);
		
		if(cartLine == null) {
			return "result=error";
		} else {
			
			//update the cart
			Cart cart = this.getCart();
			
			cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() - 1);
			cartLineDAO.updateCart(cart);
			
			//remove the cart line
			cartLineDAO.delete(cartLine);
			
			return "result=deleted";
			
		}
		
	}
	
	public String addCartLine(int productId) {
		
		String response = null;
		
		Cart cart = this.getCart();
		
		CartLine cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), productId);
		
		if(cartLine == null) {
			
			//add a new cart line
			cartLine = new CartLine();
			
			//fetch the product
			Product product = productDAO.get(productId);
			
			cartLine.setCartId(cart.getId());
			
			cartLine.setProduct(product);
			cartLine.setBuyingPrice(product.getPrice());
			cartLine.setProductCount(1);
			cartLine.setTotal(product.getPrice());
			cartLine.setAvailable(true);
			
			cartLineDAO.add(cartLine);
			
			cart.setCartLines(cart.getCartLines() + 1);
			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
			
			cartLineDAO.updateCart(cart);
			
			response = "result=added";
			
		} else {
			
			//check if the cart line has reached the maximum count
			if(cartLine.getProductCount() < 5) {
				
				//update the product count for that cartLine
				response = this.manageCartLine(cartLine.getId(), cartLine.getProductCount() + 1);
				
			} else {
				response = "result=maximum";
			}
			
		}
		
		return response;
		
	}

	
	
	
	
	
	
	
	
	
}