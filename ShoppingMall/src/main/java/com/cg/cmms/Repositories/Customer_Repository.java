package com.cg.cmms.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.cmms.Entities.Customer;

public interface Customer_Repository extends JpaRepository<Customer, Integer> {

	public List<Customer> findByshopId(Integer shopId);
}
