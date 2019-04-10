package net.romanov.supermarket.model;

public class SupplierProductModel {
	
	private String name;
	private String variety;
	
	private String country;
	private int quantity;
	
	private String date;
	private String companyName;
	
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Override
	public String toString() {
		return "SupplierProductModel [name=" + name + ", variety=" + variety + ", quantity=" + quantity + ", date="
				+ date + ", companyName=" + companyName + "]";
	}

}
