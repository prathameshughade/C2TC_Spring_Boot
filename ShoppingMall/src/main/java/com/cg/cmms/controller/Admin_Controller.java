package com.cg.cmms.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
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

import com.cg.cmms.Entities.MallAdmin;
import com.cg.cmms.Services.MallAdmin_Service;
import com.cg.cmms.Services.Shop_Service;
import com.cg.cmms.Services.User_Service;

@RestController
@Transactional
public class Admin_Controller {

	@Autowired
	private MallAdmin_Service service;
	
	@Autowired
	private User_Service userService;
	
	@Autowired
	private Shop_Service shopService;
	
	@GetMapping("/user/admin")
	public List<MallAdmin> getAllAdmin( ) {
		return service.listAll();
	}
	
	@GetMapping("/user/admin/{id}")
	public ResponseEntity<MallAdmin> getAdminById(@PathVariable Integer id) {
		try {
			MallAdmin admin = service.findById(id);
			return new ResponseEntity<>(admin,HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/user/admin")
	public void addAdmin(@RequestBody MallAdmin admin) {
		service.save(admin);
	}
	
	@PutMapping("/user/admin/{id}")
	public ResponseEntity<?> updateAdmin(@RequestBody MallAdmin admin, @PathVariable Integer id) {
		try {
			MallAdmin admin1 = service.findById(id);
			return new ResponseEntity<>(admin1,HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@DeleteMapping("/user/admin/{id}")
	public void deleteAdmin( @PathVariable Integer id) {
		service.delete(id);
	}
}
