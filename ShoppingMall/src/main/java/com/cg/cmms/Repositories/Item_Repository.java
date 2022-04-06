package com.cg.cmms.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.cmms.Entities.Item;

public interface Item_Repository extends JpaRepository<Item, Integer> {

}
