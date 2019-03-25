package net.romanov.supermarket.handler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.romanov.supermarket.model.CheckoutModel;
import net.romanov.supermarket.model.UserModel;
import net.romanov.supermarketbackend.dao.CartLineDAO;
import net.romanov.supermarketbackend.dao.ProductDAO;
import net.romanov.supermarketbackend.dao.UserDAO;
import net.romanov.supermarketbackend.dto.Address;
import net.romanov.supermarketbackend.dto.Cart;
import net.romanov.supermarketbackend.dto.CartLine;
import net.romanov.supermarketbackend.dto.OrderDetail;
import net.romanov.supermarketbackend.dto.OrderItem;
import net.romanov.supermarketbackend.dto.Product;
import net.romanov.supermarketbackend.dto.User;

@Component
public class CheckoutHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(CheckoutHandler.class);
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private HttpSession session;
	
public CheckoutModel init(String name) throws Exception {
		
		User user = userDAO.getByEmail(name);
		CheckoutModel checkoutModel = null;
		
		if(user != null) {
			
			checkoutModel = new CheckoutModel();
			checkoutModel.setUser(user);
			checkoutModel.setCart(user.getCart());
			
			double checkoutTotal = 0.0;
			List<CartLine> cartLines = cartLineDAO.listAvailable(user.getCart().getId());
			
			if(cartLines.size() == 0) {
				throw new Exception("There are no products available for checkout now!");
			}
			
			for(CartLine cartLine : cartLines) {
				checkoutTotal += cartLine.getTotal();
			}
			
			checkoutModel.setCartLines(cartLines);
			checkoutModel.setCheckoutTotal(checkoutTotal);
		}
		
		return checkoutModel;
		
	}
	
	public List<Address> getShippingAddresses(CheckoutModel model) {
		
		List<Address> addresses = userDAO.listShippingAddresses(model.getUser().getId());
		
		if(addresses.size() == 0) {
			addresses = new ArrayList<>();
		}
		
		addresses.add(addresses.size(), userDAO.getBilling(model.getUser().getId()));
		
		return addresses;
		
	}
	
	public String saveAddressSelection(CheckoutModel checkoutModel, int shippingId) {
		
		String transitionValue = "success";
		
		Address shipping = userDAO.getAddress(shippingId);
		
		checkoutModel.setShipping(shipping);
		
		return transitionValue;
		
	}
	
	public String saveAddress(CheckoutModel checkoutModel, Address shipping) {
		
		String transitionValue = "success";
		
		//set the user id
		shipping.setUserId(checkoutModel.getUser().getId());
		
		//set shipping as true
		shipping.setShipping(true);
		userDAO.addAddress(shipping);
		
		//set the shipping id to flowScope object
		checkoutModel.setShipping(shipping);
		
		return transitionValue;
		
	}
	
	public String saveOrder(CheckoutModel cModel) {
		
		String transitionValue = "success";
		
		//create a new order object
		OrderDetail orderDetail = new OrderDetail();
		
		//attach the user
		orderDetail.setUser(cModel.getUser());
		
		//attach the shipping address
		orderDetail.setShipping(cModel.getShipping());
		
		//fetch the billing address
		Address billing = userDAO.getBilling(cModel.getUser().getId());
		orderDetail.setBilling(billing);
		
		List<CartLine> cartLines = cModel.getCartLines();
		OrderItem orderItem = null;
		
		double orderTotal = 0.0;
		int orderCount = 0;
		Product product = null;
		
		for(CartLine cartLine : cartLines) {
			
			orderItem = new OrderItem();
			
			orderItem.setBuyingPrice(cartLine.getBuyingPrice());
			orderItem.setProduct(cartLine.getProduct());
			orderItem.setProductCount(cartLine.getProductCount());
			orderItem.setTotal(cartLine.getTotal());
			
			orderItem.setOrderDetail(orderDetail);
			orderDetail.getOrderItems().add(orderItem);
			
			orderTotal += orderItem.getTotal();
			orderCount++;
			
			//update the product
			//reduce the quantity of product
			product = cartLine.getProduct();
			product.setQuantity(product.getQuantity() - cartLine.getProductCount());
			product.setPurchases(product.getPurchases() + cartLine.getProductCount());
			productDAO.update(product);
			
			//delete the cartLine
			cartLineDAO.delete(cartLine);
		
		}
		
		orderDetail.setOrderTotal(orderTotal);
		orderDetail.setOrderCount(orderCount);
		
		Date date = new Date();
		
		//DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
		
		//String strDate = dateFormat.format(date); 
		
		orderDetail.setOrderDate(date);
		
		//save the order
		cartLineDAO.addOrderDetail(orderDetail);
		
		//set it to the orderDetails of checkoutModel
		cModel.setOrderDetail(orderDetail);
		
		//update the cart
		Cart cart = cModel.getCart();
		cart.setGrandTotal(cart.getGrandTotal() - orderTotal);
		cart.setCartLines(cart.getCartLines() - orderCount);
		cartLineDAO.updateCart(cart);
		
		//update the cart if its in the session
		UserModel uModel = (UserModel) session.getAttribute("userModel");
		if(uModel != null) {
			uModel.setCart(cart);
		}
		
		return transitionValue;
		
	}
	
	public OrderDetail getOrderDetail(CheckoutModel checkoutModel) {
		return checkoutModel.getOrderDetail();
	}

}
