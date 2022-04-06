package com.cg.cmms.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cmms.Entities.Customer;
import com.cg.cmms.Repositories.Customer_Repository;

@Service
public class Customer_Service {

	@Autowired
	private Customer_Repository repo;
	
	public void save(Customer customer) {
		repo.save(customer);
	}
	
	public Customer update(Customer customer) {
		return repo.save(customer);
	}
	
	public List<Customer> listAll(Integer shopId) {
		return repo.findByshopId(shopId);
	}
	
	public Customer findById(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
