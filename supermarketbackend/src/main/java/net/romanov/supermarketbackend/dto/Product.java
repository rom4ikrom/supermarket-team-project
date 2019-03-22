package net.romanov.supermarketbackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Enter the Fruit Name!")
	private String name;
	
	@NotBlank(message = "Enter the Fruit Variety!")
	private String variety;
	
	@JsonIgnore
	@NotBlank(message = "Enter the Fruit Description!")
	private String description;
	
	@Min(value=1, message="The price cannot be less than 1!")
	private double price;
	
	@Min(value=1, message="The quantity cannot be less than 1!")
	private int quantity;

	@Column(name="is_active")
	private boolean isActive;
	
	@NotBlank(message = "Enter the Fruit Country!")
	private String country;
	
	@JsonIgnore
	@Column(name="region_id")
	private int regionId;

	private int purchases;
	private int views;

	private String code;

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
		this.code = "PRD_" + UUID.randomUUID().toString().substring(30).toUpperCase();
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
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
				+ description + ", quantity=" + quantity + ", isActive=" + isActive
				+ ", country=" + country + ", regionId=" + regionId + ", purchases=" + purchases + ", views=" + views + "]";
	}

}
