package com.cg.cmms.Entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer user_id;                                         //  Primary Key
	
	@Column(name="name")
	private String name;
	
	@Column(name="type")
	private String type;
	
	@Column(name="password")
	private String password;
	
	@OneToOne(mappedBy="user")                            //	One to One mapped with Shop Owner
	private ShopOwner shopOwner;
	
	@OneToOne(mappedBy="user")                            //	One to One mapped with MallAdmin
	private MallAdmin mallAdmin;
	
	@OneToOne(mappedBy="user")                            //	One to One mapped with Customer
	private Customer customer;

	public User() {
		
	}
	
	public User(Integer id) {
		this.user_id=id;
	}
	
//	***  Getters and Setters  *** ------------------------------------------------------------>

	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ShopOwner getShopOwner() {
		return shopOwner;
	}

	public void setShopOwner(ShopOwner shopOwner) {
		this.shopOwner = shopOwner;
	}

	public MallAdmin getMallAdmin() {
		return mallAdmin;
	}

	public void setMallAdmin(MallAdmin mallAdmin) {
		this.mallAdmin = mallAdmin;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
