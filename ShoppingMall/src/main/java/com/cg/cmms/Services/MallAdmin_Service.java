package com.cg.cmms.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cmms.Entities.MallAdmin;
import com.cg.cmms.Repositories.MallAdmin_Repository;

@Service
public class MallAdmin_Service {

	@Autowired
	private MallAdmin_Repository repo;
	
	public void save(MallAdmin mallAdmin) {
		repo.save(mallAdmin);
	}
	
	public MallAdmin update(MallAdmin mallAdmin) {
		return repo.save(mallAdmin);
	}
	
	public List<MallAdmin> listAll() {
		return repo.findAll();
	}
	
	public MallAdmin findById(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
