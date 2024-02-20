package com.tarea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarea.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
