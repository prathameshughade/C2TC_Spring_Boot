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

import com.cg.cmms.Entities.Employee;
import com.cg.cmms.Entities.Shop;
import com.cg.cmms.Services.Employee_Service;

@RestController
@Transactional
public class Employee_Controller {

	@Autowired
	private Employee_Service service;
	
	@GetMapping("/shop/{shopId}/employee")
	public List<Employee> getAllEmployee(@PathVariable Integer shopId) {
		return service.listAll(shopId);
	}
	
	@GetMapping("/shop/{shopId}/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
		try {
			Employee emp = service.findById(id);
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/shop/{shopId}/employee")
	public void AddEmployee(@RequestBody Employee employee, @PathVariable Integer shopId) {
		employee.setShop(new Shop(shopId));
		service.save(employee);
	}
	
	@PutMapping("/shop/{shopId}/employee/{id}")
	public ResponseEntity<?> update(@RequestBody Employee employee, @PathVariable Integer shopId, @PathVariable Integer id) {
		try {
			employee.setShop(new Shop(shopId));
			service.save(employee);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@DeleteMapping("/shop/{shopId}/employee/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
