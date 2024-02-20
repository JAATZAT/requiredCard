package com.tarea.service;

import java.util.List;
import java.util.Optional;

import com.tarea.model.Customer;

public interface ICustomerService {
	
	List<Customer> getAllCustomer();

    Optional<Customer> findById(int id);

    Customer save(Customer customer);

    void update(Customer customer);

    void deleteById(int id);

}
