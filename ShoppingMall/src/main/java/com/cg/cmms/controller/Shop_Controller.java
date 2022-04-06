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

import com.cg.cmms.Entities.Shop;
import com.cg.cmms.Services.Shop_Service;

@RestController
@Transactional
public class Shop_Controller {

	@Autowired
	private Shop_Service service;
	
	@GetMapping("/shop")
	public List<Shop> getAllShop( ) {
		return service.listAll();
	}
	
	@GetMapping("/shop/{id}")
	public ResponseEntity<Shop> getShopById(@PathVariable Integer id) {
		try {
			Shop shop = service.findById(id);
			return new ResponseEntity<>(shop,HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/shop")
	public void addShop(@RequestBody Shop shop) {
		service.save(shop);
	}
	
	@PutMapping("/shop/{id}")
	public ResponseEntity<?> updateShop(@RequestBody Shop shop, @PathVariable Integer id) {
		try {
			Shop shop1 = service.findById(id);
			return new ResponseEntity<>(shop1,HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@DeleteMapping("/shop/{id}")
	public void deleteShop( @PathVariable Integer id) {
		service.delete(id);
	}
}
