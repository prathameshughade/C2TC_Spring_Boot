package com.cg.cmms.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.cmms.Entities.Employee;

public interface Employee_Repository extends JpaRepository<Employee, Integer> {

	public List<Employee> findByShopId(Integer shopId);
}
