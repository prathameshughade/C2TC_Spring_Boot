package com.cg.cmms.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cmms.Entities.Employee;
import com.cg.cmms.Repositories.Employee_Repository;

@Service
public class Employee_Service {

	@Autowired
	private Employee_Repository repo;

	public void save(Employee employee) {
		repo.save(employee);
	}

	public Employee update(Employee employee) {
		return repo.save(employee);
	}

	public List<Employee> listAll(Integer shopId) {
		return repo.findByShopId(shopId);
	}

	public Employee findById(Integer id) {
		return repo.findById(id).get();
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
