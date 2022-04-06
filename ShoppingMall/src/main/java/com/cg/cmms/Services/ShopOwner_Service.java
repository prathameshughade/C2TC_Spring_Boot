package com.cg.cmms.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cmms.Entities.ShopOwner;
import com.cg.cmms.Repositories.ShopOwner_Repository;

@Service
public class ShopOwner_Service {

	@Autowired
	private ShopOwner_Repository repo;
	
	public void save(ShopOwner shopOwner) {
		repo.save(shopOwner);
	}
	
	public ShopOwner update(ShopOwner shopOwner) {
		return repo.save(shopOwner);
	}
	
	public List<ShopOwner> listAll() {
		return repo.findAll();
	}
	
	public ShopOwner findById(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
