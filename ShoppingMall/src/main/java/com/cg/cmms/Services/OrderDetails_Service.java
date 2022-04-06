package com.cg.cmms.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cmms.Entities.OrderDetails;
import com.cg.cmms.Repositories.OrderDetails_Repository;

@Service
public class OrderDetails_Service {

	@Autowired
	private OrderDetails_Repository repo;
	
	public void save(OrderDetails orderDetails) {
		repo.save(orderDetails);
	}
	
	public OrderDetails update(OrderDetails orderDetails) {
		return repo.save(orderDetails);
	}
	
	public List<OrderDetails> listAll() {
		return repo.findAll();
	}
	
	public OrderDetails findById(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
