package net.romanov.supermarketbackend.dao;

import java.util.List;

import net.romanov.supermarketbackend.dto.Address;
import net.romanov.supermarketbackend.dto.User;

public interface UserDAO {
	
	User getByEmail(String email);
	User get(int id);
	
	boolean add(User user);
	
	Address getBilling(int userId);
	List<Address> listShippingAddresses(int userId);

}
