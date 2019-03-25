package net.romanov.supermarketbackend.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) //h2 database
	@Column(name = "ID") //ojdbc
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence") //ojdbc
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ") //ojdbc
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name="order_total")
	private double orderTotal;
	
	@ManyToOne
	private Address shipping;
	
	@ManyToOne
	private Address billing;
	
	@OneToMany(mappedBy="orderDetail", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<OrderItem> orderItems = new ArrayList<>();
	
	@Column(name = "order_count")
	private int orderCount;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "order_date")
	private Date orderDate;

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

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public Address getShipping() {
		return shipping;
	}

	public void setShipping(Address shipping) {
		this.shipping = shipping;
	}

	public Address getBilling() {
		return billing;
	}

	public void setBilling(Address billing) {
		this.billing = billing;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", user=" + user + ", orderTotal=" + orderTotal + ", shipping=" + shipping
				+ ", billing=" + billing + ", orderItems=" + orderItems + ", orderCount=" + orderCount + ", orderDate="
				+ orderDate + "]";
	}

}
