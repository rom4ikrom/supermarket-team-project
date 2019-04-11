package net.romanov.supermarketbackend.dao;

import java.util.List;

import net.romanov.supermarketbackend.dto.Address;
import net.romanov.supermarketbackend.dto.PaymentDetails;
import net.romanov.supermarketbackend.dto.User;

public interface UserDAO {
	
	User getByEmail(String email);
	User getUser(int id);
	
	boolean addUser(User user);
	
	boolean addAddress(Address address);
	
	Address getAddress(int addressId);
	Address getBilling(int userId);
	List<Address> listShippingAddresses(int userId);
	
	/* method for payment details
	//get user payment details
	List<PaymentDetails> listPaymentDetails(int userId);
	PaymentDetails getPaymentDetails(int paymentId);
	
	//save payment details
	boolean addPaymentDetails(PaymentDetails paymentDetails);
	
	PaymentDetails getPaymentByCardNumber(String cardNumber);
	*/

}
