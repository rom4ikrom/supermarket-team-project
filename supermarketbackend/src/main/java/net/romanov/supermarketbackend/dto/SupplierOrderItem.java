package net.romanov.supermarketbackend.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "supplier_order_item")
public class SupplierOrderItem implements Serializable {

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
	
	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "supplier_id")
	private int supplierId;
	
	private int quantity;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "sup_order_date")
	private Date supOrderDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getSupOrderDate() {
		return supOrderDate;
	}

	public void setSupOrderDate(Date supOrderDate) {
		this.supOrderDate = supOrderDate;
	}

	@Override
	public String toString() {
		return "SupplierOrderItem [id=" + id + ", productId=" + productId + ", supplierId=" + supplierId + ", quantity="
				+ quantity + ", supOrderDate=" + supOrderDate + "]";
	}

}
