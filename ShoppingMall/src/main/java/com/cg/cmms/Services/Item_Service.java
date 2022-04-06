package com.cg.cmms.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cmms.Entities.Item;
import com.cg.cmms.Repositories.Item_Repository;

@Service
public class Item_Service {

	@Autowired
	private Item_Repository repo;
	
	public void save(Item item) {
		repo.save(item);
	}
	
	public Item update(Item item) {
		return repo.save(item);
	}
	
	public List<Item> listAll() {
		return repo.findAll();
	}
	
	public Item findById(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
