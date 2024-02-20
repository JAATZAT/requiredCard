package com.tarea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarea.model.CreditCheck;

public interface CreditCheckRepository extends JpaRepository<CreditCheck, Integer> {

	
}
