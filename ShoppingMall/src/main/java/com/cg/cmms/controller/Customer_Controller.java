package com.cg.cmms.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cmms.Entities.Customer;
import com.cg.cmms.Entities.OrderDetails;
import com.cg.cmms.Entities.Shop;
import com.cg.cmms.Services.Customer_Service;
import com.cg.cmms.Services.OrderDetails_Service;

@RestController
@Transactional
public class Customer_Controller {

	@Autowired
	private Customer_Service service;
	
	@Autowired
	private OrderDetails_Service orderService;
	
	@GetMapping("/shop/{shopId}/customer")
	public List<Customer> getAllCustomer(@PathVariable Integer shopId) {
		return service.listAll(shopId);
	}
	
	@GetMapping("/shop/customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
		try {
			Customer customer = service.findById(id);
			return new ResponseEntity<>(customer,HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/shop/{shopId}/customer")
	public void addCustomer(@RequestBody Customer customer, @PathVariable Integer shopId) {
		customer.setShop(new Shop(shopId));
		service.save(customer);
	}
	
	@PutMapping("/shop/{shopId}/customer/{id}")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable Integer id,  @PathVariable Integer shopId) {
		try {
			customer.setShop(new Shop(shopId));
			service.save(customer);
			return new ResponseEntity<>(customer,HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@DeleteMapping("/shop/{shopId}/customer/{id}")
	public void deleteCustomer( @PathVariable Integer id) {
		service.delete(id);
	}
	
//	@PostMapping("/shop/{shopId}/customer/{customerId}/order/{id}")
//	public void Order(@RequestBody OrderDetails od, @PathVariable Integer shopId,  @PathVariable Integer id,  @PathVariable Integer customerId) {
//		od.setShop(new Shop(shopId));
//		od.setCustomer(new Customer(id));
//		orderService.save(od);
//	}
}
