package net.romanov.supermarket.model;

import java.io.Serializable;
import java.util.List;

import net.romanov.supermarketbackend.dto.Address;
import net.romanov.supermarketbackend.dto.Cart;
import net.romanov.supermarketbackend.dto.CartLine;
import net.romanov.supermarketbackend.dto.OrderDetail;
import net.romanov.supermarketbackend.dto.User;

public class CheckoutModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	private Address shipping;
	private Cart cart;
	private List<CartLine> cartLines;
	private OrderDetail orderDetail;
	private double checkoutTotal;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getShipping() {
		return shipping;
	}
	public void setShipping(Address shipping) {
		this.shipping = shipping;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public List<CartLine> getCartLines() {
		return cartLines;
	}
	public void setCartLines(List<CartLine> cartLines) {
		this.cartLines = cartLines;
	}
	public OrderDetail getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}
	public double getCheckoutTotal() {
		return checkoutTotal;
	}
	public void setCheckoutTotal(double checkoutTotal) {
		this.checkoutTotal = checkoutTotal;
	}
	
	@Override
	public String toString() {
		return "CheckoutModel [user=" + user + ", shipping=" + shipping + ", cart=" + cart + ", cartLines=" + cartLines
				+ ", orderDetail=" + orderDetail + ", checkoutTotal=" + checkoutTotal + "]";
	}

}
