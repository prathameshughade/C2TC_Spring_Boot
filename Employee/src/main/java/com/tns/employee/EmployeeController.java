package com.tns.employee;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
	
	 @Autowired
	 private EmployeeService service;
	 
	 // RESTful API methods for Retrieval operations
	 @GetMapping("/employee")
	 public List<Employee> list() 
	 {
	 return service.listAll();
	 }
	 @GetMapping("/employee/{id}")
	 public ResponseEntity<Employee> get(@PathVariable Integer id) 
	 {
	 try
	 {
		 Employee employee = service.get(id);
	 return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	 } 
	 catch (NoSuchElementException e) 
	 {
	 return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	 } 
	 }
	 // RESTful API method for Create operation
	 @PostMapping("/employee")
	 public void add(@RequestBody Employee employee) 
	 {
	 service.save(employee);
	 }
	 
	 // RESTful API method for Update operation
	 @PutMapping("/employee/{id}")
	 public ResponseEntity<?> update(@RequestBody Employee employee, @PathVariable Integer id) 
	 {
	 try
	 {
		 Employee existEmployee = service.get(id);
	 service.save(employee);
	 return new ResponseEntity<>(HttpStatus.OK);
	 } 
	 catch (NoSuchElementException e) 
	 {
	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 } 
	 }
	 // RESTful API method for Delete operation
	 @DeleteMapping("/employee/{id}")
	 public void delete(@PathVariable Integer id) 
	 {
	 service.delete(id);
	 }
	}



