package net.romanov.supermarketbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY) //h2 database
	@Column(name = "ID") //ojdbc
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence") //ojdbc
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ") //ojdbc
	private int id;
	
	@OneToOne
	private User user;
	
	@Column(name = "grand_total")
	private double grandTotal;
	
	@Column(name = "cart_lines")
	private int cartLines;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public int getCartLines() {
		return cartLines;
	}

	public void setCartLines(int cartLines) {
		this.cartLines = cartLines;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", user=" + user + ", grandTotal=" + grandTotal + ", cartLines=" + cartLines + "]";
	}

}
