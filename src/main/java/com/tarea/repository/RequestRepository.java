package com.tarea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tarea.model.Request;

public interface RequestRepository extends JpaRepository<Request, Integer>{
    
	@Query(nativeQuery = true, value = "SELECT * FROM REQUESTS")
	public List<Request>getAll();

	public Object findById(int id);
}
