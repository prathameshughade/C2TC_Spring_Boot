package com.cg.cmms.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cmms.Entities.Shop;
import com.cg.cmms.Repositories.Shop_Repository;

@Service
public class Shop_Service {

	@Autowired
	private Shop_Repository repo;
	
	public void save(Shop shop) {
		repo.save(shop);
	}
	
	public Shop update(Shop shop) {
		return repo.save(shop);
	}
	
	public List<Shop> listAll() {
		return repo.findAll();
	}
	
	public Shop findById(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
