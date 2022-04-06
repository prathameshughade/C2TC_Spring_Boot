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

import com.cg.cmms.Entities.OrderDetails;
import com.cg.cmms.Services.OrderDetails_Service;

@RestController
@Transactional
public class OrderController {

	@Autowired
	private OrderDetails_Service service;
	
	@GetMapping("/user/customer/{customerId}/order")
	public List<OrderDetails> getAllOrder() {
		return service.listAll();
	}
	
	@GetMapping("/user/customer/{customerId}/order/{id}")
	public ResponseEntity<OrderDetails> getOrderById(@PathVariable Integer id, @PathVariable Integer customerId) {
		try {
			OrderDetails customer = service.findById(id);
			return new ResponseEntity<>(customer,HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/user/customer/{customerId}/order")
	public void addOrder(@RequestBody OrderDetails customer) {
		service.save(customer);
	}
	
	@PutMapping("/user/customer/{customerId}/order/{id}")
	public ResponseEntity<?> updateOrder(@RequestBody OrderDetails customer, @PathVariable Integer id,  @PathVariable Integer customerId) {
		try {
			service.save(customer);
			return new ResponseEntity<>(customer,HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@DeleteMapping("/user/customer/{customerId}/order/{id}")
	public void deleteOrder( @PathVariable Integer id) {
		service.delete(id);
	}
}
