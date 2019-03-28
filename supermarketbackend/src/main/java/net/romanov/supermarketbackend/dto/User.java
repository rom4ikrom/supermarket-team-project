package net.romanov.supermarketbackend.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "user_detail")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //h2 database
//	@Column(name = "ID") //ojdbc
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence") //ojdbc
//	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ") //ojdbc
	private int id;
	
	@NotBlank(message = "Please enter First Name")
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank(message = "Please enter Last Name!")
	@Column(name = "last_name")
	private String lastName;
	
	private String role;
	
	@NotBlank(message = "Please enter Email address!")
	private String email;
	
	@NotBlank(message = "Please enter Contact Number!")
	private String tel; //h2 database
	
	//h2 database tel field is a string 
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	/*
	//for ojdbc where tel is a number
	private int tel;
	
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	
	*/
	
	@NotBlank(message = "Please enter Password!")
	private String password;
	
	@NotBlank(message = "Please enter Password Hint!")
	private String hint;
	
//	@Type(type = "boolean") //ojdbc
	private boolean enabled;
	
	@Transient
	@NotBlank(message = "Please enter Confirm Password!")
	private String confirmPassword;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Cart cart;
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role + ", email="
				+ email + ", tel=" + tel + ", password=" + password + ", hint=" + hint + ", enabled=" + enabled
				+ ", confirmPassword=" + confirmPassword + ", cart=" + cart + "]";
	}
	
}
