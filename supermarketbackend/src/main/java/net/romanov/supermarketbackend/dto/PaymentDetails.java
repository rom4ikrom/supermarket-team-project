package net.romanov.supermarketbackend.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "payment_details")
public class PaymentDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "ID") //ojdbc
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence") //ojdbc
//	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ") //ojdbc
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Size(min = 16, max = 16, message = "Card Number must have 16 digits!")
	@Column(name = "card_number")
	private String cardNumber;
	
	@NotBlank(message = "Please enter the name on card!")
	@Column(name = "card_name")
	private String cardName;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "expiry_date", nullable = false)
	private Date expiryDate;
	
	@NotBlank(message = "Please enter CVV!")
	private String cvv;
	
	@Column(name = "is_active")
//	@Type(type = "boolean") //ojdbc
	private boolean active;
	
	@Transient
	private String month;
	
	@Transient
	private String year;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "PaymentDetails [id=" + id + ", userId=" + userId + ", cardNumber=" + cardNumber + ", cardName="
				+ cardName + ", expiryDate=" + expiryDate + ", cvv=" + cvv + ", active=" + active + "]";
	}

}
