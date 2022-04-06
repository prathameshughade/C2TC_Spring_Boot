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

import com.cg.cmms.Entities.User;
import com.cg.cmms.Services.User_Service;

@RestController
@Transactional
public class User_Controller {

	@Autowired
	private User_Service service;
	
	@GetMapping("/user")
	public List<User> getAllUsers( ) {
		return service.listAll();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) {
		try {
			User user = service.findById(id);
			return new ResponseEntity<>(user,HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/user")
	public void addUser(@RequestBody User user) {
		service.save(user);
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Integer id) {
		try {
			service.save(user);
			return new ResponseEntity<>(user,HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser( @PathVariable Integer id) {
		service.delete(id);
	}
	
}
