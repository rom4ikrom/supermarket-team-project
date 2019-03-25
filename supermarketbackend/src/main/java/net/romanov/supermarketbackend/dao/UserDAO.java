package net.romanov.supermarketbackend.dao;

import java.util.List;

import net.romanov.supermarketbackend.dto.Address;
import net.romanov.supermarketbackend.dto.User;

public interface UserDAO {
	
	User getByEmail(String email);
	User getUser(int id);
	
	boolean addUser(User user);
	
	boolean addAddress(Address address);
	
	Address getAddress(int addressId);
	Address getBilling(int userId);
	List<Address> listShippingAddresses(int userId);

}
