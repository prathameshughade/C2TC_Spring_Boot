package com.cg.cmms.Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="shop")
public class Shop implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="shop_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="shop_category")
	private String shopCategory;
	
	@Column(name="shop_name")
	private String shopName;
	
	@Column(name="shop_status")
	private String shopStatus;
	
	@Column(name="lease_status")
	private String leaseStatus;
	
	@OneToOne(mappedBy="shop")
	ShopOwner shopOwner;	
	
	@OneToMany(mappedBy="shop",cascade=CascadeType.ALL)
	private List<Employee> employee;

	@OneToMany(mappedBy="shop",cascade=CascadeType.ALL)
	private List<Item> item;
	
	@OneToMany(mappedBy="shop",cascade=CascadeType.ALL)
	private List<OrderDetails> orderDetails;
	
	@OneToMany(mappedBy="shop",cascade=CascadeType.ALL)
	private List<Customer> customer;
	
	@ManyToOne
	@JoinColumn(name="mall_id")
	private Mall mall;

	public Shop() {
		
	}
	
	public Shop(Integer id) {
		this.id=id;
	}
	
//	** Getters and Setters ** ------------------------------------------------------------>
	
	
	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShopCategory() {
		return shopCategory;
	}

	public void setShopCategory(String shopCategory) {
		this.shopCategory = shopCategory;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopStatus() {
		return shopStatus;
	}

	public void setShopStatus(String shopStatus) {
		this.shopStatus = shopStatus;
	}

	public String getLeaseStatus() {
		return leaseStatus;
	}

	public void setLeaseStatus(String leaseStatus) {
		this.leaseStatus = leaseStatus;
	}

	public ShopOwner getShopOwner() {
		return shopOwner;
	}

	public void setShopOwner(ShopOwner shopOwner) {
		this.shopOwner = shopOwner;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public Mall getMall() {
		return mall;
	}

	public void setMall(Mall mall) {
		this.mall = mall;
	}

}
