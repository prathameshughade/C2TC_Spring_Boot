package com.cg.cmms.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cmms.Entities.Mall;
import com.cg.cmms.Repositories.Mall_Repository;

@Service
public class Mall_Service {

	@Autowired
	private Mall_Repository repo;
	
	public void save(Mall mall) {
		repo.save(mall);
	}
	
	public Mall update(Mall mall) {
		return repo.save(mall);
	}
	
	public List<Mall> listAll() {
		return repo.findAll();
	}
	
	public Mall findById(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
