package net.romanov.supermarketbackend.daoimpl;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import net.romanov.supermarketbackend.dao.UserDAO;
import net.romanov.supermarketbackend.dto.Address;
import net.romanov.supermarketbackend.dto.PaymentDetails;
import net.romanov.supermarketbackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User getByEmail(String email) {
		
		String selectQuery = "FROM User WHERE email = :email";
		try {
			return sessionFactory
					.getCurrentSession()
					.createQuery(selectQuery, User.class)
					.setParameter("email", email)
					.getSingleResult();
		} catch(Exception ex) {
			return null;
		}
		
	}

	@Override
	public User getUser(int id) {
		try {
			return sessionFactory.getCurrentSession().get(User.class, id);
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean addAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().persist(address);
			return true; 
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Address getBilling(int userId) {
		
		String selectQuery = "FROM Address WHERE user_id = :userId AND billing = :billing";
		
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, Address.class)
					.setParameter("userId", userId)
					.setParameter("billing", true)
					.getSingleResult();
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public List<Address> listShippingAddresses(int userId) {
		
		String selectQuery = "FROM Address WHERE user_id = :userId AND shipping = :shipping";
		
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, Address.class)
					.setParameter("userId", userId)
					.setParameter("shipping", true)
					.getResultList();
		} catch (Exception ex) {
			return null;
		}
		
	}

	@Override
	public Address getAddress(int addressId) {
		try {
			return sessionFactory.getCurrentSession().get(Address.class, addressId);
		} catch (Exception ex) {
			return null;
		}
	}
	
	/*
	@Override
	public List<PaymentDetails> listPaymentDetails(int userId) {
		
		String query = "FROM PaymentDetails WHERE user_id = :userId AND is_active = :active";
		
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(query, PaymentDetails.class)
					.setParameter("userId", userId)
					.setParameter("active", true)
					.getResultList();
		} catch (Exception ex) {
			return null;
		}
		
	}
	
	@Override
	public PaymentDetails getPaymentDetails(int paymentId) {
		
		String query = "FROM PaymentDetails WHERE id = :id";
		
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(query, PaymentDetails.class)
					.setParameter("id", paymentId)
					.getSingleResult();
		} catch (Exception ex) {
			return null;
		}
		
	}

	@Override
	public boolean addPaymentDetails(PaymentDetails paymentDetails) {
		try {
			
			sessionFactory.getCurrentSession().persist(paymentDetails);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public PaymentDetails getPaymentByCardNumber(String cardNumber) {
		
		String selectQuery = "FROM PaymentDetails WHERE card_number = :cardNumber";
		try {
			return sessionFactory
					.getCurrentSession()
					.createQuery(selectQuery, PaymentDetails.class)
					.setParameter("cardNumber", cardNumber)
					.getSingleResult();
		} catch(Exception ex) {
			return null;
		}
	}
	*/

}
