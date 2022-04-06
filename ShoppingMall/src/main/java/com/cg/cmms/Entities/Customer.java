package com.cg.cmms.Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Customer_id")                          	
	private Integer id;                                               //  Primary Key
	
	@Column(name="name")
	private String name;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL)      // One to Many mapping with Order Details       
	private List<OrderDetails> orderDetails;
	
	@OneToOne(cascade=CascadeType.ALL)                            //  One to One mapping with User
	@JoinColumn(name="user_id")
	private User user;                                            //  Foreign Key (User)
	
	@ManyToOne
	@JoinColumn(name="shop_id")
	private Shop shop;

	public Customer() {
		
	}
	
	public Customer(Integer id) {
		this.id=id;
	}
	
//	***  Getters and Setters  *** ------------------------------------------------------------>

	
	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
}