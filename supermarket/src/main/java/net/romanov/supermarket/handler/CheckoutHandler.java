package net.romanov.supermarket.handler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
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
import net.romanov.supermarketbackend.dto.PaymentDetails;
import net.romanov.supermarketbackend.dto.Product;
import net.romanov.supermarketbackend.dto.Supplier;
import net.romanov.supermarketbackend.dto.SupplierOrderItem;
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
			
			PaymentDetails pd = new PaymentDetails();
			
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
	
	public List<CartLine> getCartLines(CheckoutModel model) {
		
		List<CartLine> listCartLines = cartLineDAO.list(model.getCart().getId());
		
		if(listCartLines.size() == 0) {
			listCartLines = new ArrayList<>();
		}
		
		return listCartLines;
		
	}
	
	/*
	 * get payment details from database for logged user
	public List<PaymentDetails> getPaymentDetails(CheckoutModel model) throws ParseException {

		List<PaymentDetails> listPaymentDetails = userDAO.listPaymentDetails(model.getUser().getId());

		if(listPaymentDetails.size() == 0) {
			listPaymentDetails = new ArrayList<>();
		}

		if(listPaymentDetails.size() >= 1) {
			for(PaymentDetails pd : listPaymentDetails) {
				String cardNumber = pd.getCardNumber();

				cardNumber = cardNumber.substring(12, 16);
				pd.setCardNumber("**** " + cardNumber);
				
			}
		}

		return listPaymentDetails;

	}
	*/
	
	/*
	 * save selected payment details to checkout model
	public String savePaymentSelection(CheckoutModel checkoutModel, int paymentId) {
		
		String transitionValue = "success";

		PaymentDetails paymentDetails = userDAO.getPaymentDetails(paymentId);

		checkoutModel.setCurrentPD(paymentDetails);
		
		System.out.println(paymentDetails.getCardNumber());

		return transitionValue;
		
	}
	*/
	
	
	//method to validate payment details
	public String validatePaymentDetails(PaymentDetails paymentDetails, MessageContext error) throws ParseException {
		
		String transitionValue = "success";
		
		/*
		String cardNumber = paymentDetails.getCardNumber();
		
		if(userDAO.getPaymentByCardNumber(cardNumber) != null) {
			error.addMessage(new MessageBuilder().error().source("cardNumber")
					.defaultText("This card is already registered!").build());
				
				transitionValue = "failure";
		}
		*/
		
		String month = paymentDetails.getMonth();
		String year = paymentDetails.getYear();
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String expiryDateStr = "01-" + month + "-" + year;
		
		Date expiryDate = format.parse(expiryDateStr);
		
		if(expiryDate.before(new Date())) {
			error.addMessage(new MessageBuilder().error().source("month")
					.defaultText("Card is not valid!").build());
				
				transitionValue = "failure";
		}
		
		return transitionValue;
		
	}
	
	
	
	/*
	 * method to save payment details to database - not a good decision
	public String savePaymentDetails(CheckoutModel model, PaymentDetails paymentDetails) {
		String transitionValue = "success";
		
		//set the user id
		paymentDetails.setUserId(model.getUser().getId());
		
		String month = paymentDetails.getMonth();
		String year = paymentDetails.getYear();
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String expiryDateStr = "01-" + month + "-" + year;
		
		Date expiryDate;
		
		
		try {
			expiryDate = format.parse(expiryDateStr);
			paymentDetails.setExpiryDate(expiryDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		paymentDetails.setActive(true);
		
		userDAO.addPaymentDetails(paymentDetails);
		
		model.setCurrentPD(paymentDetails);
		
		return transitionValue;
		
	}
	*/
	
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
			
			if(product.getQuantity() < 1) {
				product.setActive(false);
			}
			
			//add trigger to insert a new row to supplier_order_item table if quantity of product less than 5
			if(product.getQuantity() < 3) {
				
				if(productDAO.getSupOrderItemByProductId(product.getId()) == null) {
					
					SupplierOrderItem supOrderItem = new SupplierOrderItem();
					
					supOrderItem.setProductId(product.getId());
					supOrderItem.setSupplierId(product.getSupplierId());
					supOrderItem.setSupOrderDate(new Date());
					supOrderItem.setQuantity(7);
					
					productDAO.addSupOrderItem(supOrderItem);
				}

			}
			
			product.setPurchases(product.getPurchases() + cartLine.getProductCount());
			productDAO.update(product);

			//delete the cartLine
			cartLineDAO.delete(cartLine);

		}

		orderDetail.setOrderTotal(orderTotal);
		orderDetail.setOrderCount(orderCount);

		Date date = new Date();

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
