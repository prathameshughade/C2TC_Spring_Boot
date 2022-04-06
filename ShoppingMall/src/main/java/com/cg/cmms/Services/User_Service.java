package com.cg.cmms.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cmms.Entities.User;
import com.cg.cmms.Repositories.User_Repository;

@Service
public class User_Service {

	@Autowired
	private User_Repository repo;
	
	public void save(User user) {
		repo.save(user);
	}
	
	public User update(User user) {
		return repo.save(user);
	}
	
	public List<User> listAll() {
		return repo.findAll();
	}
	
	public User findById(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
