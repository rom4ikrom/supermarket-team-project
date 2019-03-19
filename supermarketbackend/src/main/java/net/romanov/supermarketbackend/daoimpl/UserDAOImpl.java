package net.romanov.supermarketbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.romanov.supermarketbackend.dao.UserDAO;
import net.romanov.supermarketbackend.dto.Address;
import net.romanov.supermarketbackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Address getBilling(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> listShippingAddresses(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
