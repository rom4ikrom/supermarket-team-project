package net.romanov.supermarketbackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String code;
	
	private String name;
	private String variety;
	
	@JsonIgnore
	private String description;
	
	@Column(name="unit_price")
	private int unitPrice;
	
	private int quantity;
	
	@Column(name="is_active")
	private boolean isActive;
	
	private String country;
	
	private int purchases;
	private int views;
	
	@Transient
	private MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}


	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	//default constructor
		public Product() {
			this.code = "PRD_" + this.name + "_" + this.variety+ "_" + UUID.randomUUID().toString().substring(30).toUpperCase();
		}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVariety() {
		return variety;
	}
	public void setVariety(String variety) {
		this.variety = variety;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPurchases() {
		return purchases;
	}
	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", name=" + name + ", variety=" + variety + ", description="
				+ description + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", isActive=" + isActive
				+ ", country=" + country + ", purchases=" + purchases + ", views=" + views + "]";
	}
	
	
	

}
