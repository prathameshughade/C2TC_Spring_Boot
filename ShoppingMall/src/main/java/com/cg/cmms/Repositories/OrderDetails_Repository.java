package com.cg.cmms.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.cmms.Entities.OrderDetails;

public interface OrderDetails_Repository extends JpaRepository<OrderDetails, Integer> {

}
