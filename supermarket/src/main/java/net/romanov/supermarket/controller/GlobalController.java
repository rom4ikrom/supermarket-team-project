package net.romanov.supermarket.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.romanov.supermarket.model.UserModel;
import net.romanov.supermarketbackend.dao.SupplierDAO;
import net.romanov.supermarketbackend.dao.UserDAO;
import net.romanov.supermarketbackend.dto.Supplier;
import net.romanov.supermarketbackend.dto.User;

@ControllerAdvice
public class GlobalController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	private UserModel userModel;
	
	@ModelAttribute("userModel")
	public UserModel getUserModel() {
		
		if(session.getAttribute("userModel") == null) {
			
			//add the user model
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			User user = userDAO.getByEmail(authentication.getName());
			
			if(user != null) {
				
				//create a new UserModel to pass the user details
				userModel = new UserModel();
				
				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setFullName(user.getFirstName() + " " + user.getLastName());
				
				if(userModel.getRole().equals("USER")) {
					
					//set the cart only if the user is a customer
					userModel.setCart(user.getCart());
					
				}
				
				//set the userModel in the session
				session.setAttribute("userModel", userModel);
				
				return userModel;
				
			}
			
			//get the supplier
			Supplier supplier = supplierDAO.getByEmail(authentication.getName());
			
			if(supplier != null) {
				
				userModel = new UserModel();
				
				userModel.setId(supplier.getId());
				userModel.setEmail(supplier.getEmail());
				userModel.setRole(supplier.getRole());
				userModel.setFullName(supplier.getFirstName() + " " + supplier.getLastName());
				
				//set the userModel in the session
				session.setAttribute("userModel", userModel);
				
				return userModel;
				
			}
			
		}
		
		return (UserModel) session.getAttribute("userModel");
		
	}

}
