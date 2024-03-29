package com.web.evm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.web.evm.entity.Event;

public interface EventRepo extends JpaRepository<Event, Integer>{

	@Query("SELECT p FROM Event p WHERE "
			+ "p.title LIKE CONCAT('%',:query, '%')" 
			+ "Or p.description LIKE CONCAT('%', :query, '%')")
	
    List<Event> searchEvents(String query);

}
