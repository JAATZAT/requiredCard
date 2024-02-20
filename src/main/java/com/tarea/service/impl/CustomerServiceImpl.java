package com.tarea.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarea.model.Customer;
import com.tarea.repository.CustomerRepository;
import com.tarea.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
    private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> customerList = new ArrayList<>();
		Customer customer1 = new Customer();
		customer1.setClienteID(1);
		customer1.setNombre("Juan");
		customer1.setApellido("Pérez");
		customer1.setDireccion("Calle 123");
		customer1.setTelefono("555-1234");
		customer1.setEmail("juan.perez@example.com");
		customer1.setIngresos(50000.00);
		customer1.setHistorialCrediticio("Bueno");
		customerList.add(customer1);

		Customer customer2 = new Customer();
		customer2.setClienteID(2);
		customer2.setNombre("María");
		customer2.setApellido("González");
		customer2.setDireccion("Avenida 456");
		customer2.setTelefono("555-5678");
		customer2.setEmail("maria.gonzalez@example.com");
		customer2.setIngresos(75000.00);
		customer2.setHistorialCrediticio("Excelente");
		customerList.add(customer2);
		return customerList;
	}
	
	 @Override
	    public Optional<Customer> findById(int id) {
	        return customerRepository.findById(id);
	    }

	    @Override
	    public Customer save(Customer customer) {
	        return customerRepository.save(customer);
	    }

	    @Override
	    public void update(Customer customer) {
	        customerRepository.save(customer);
	    }

	    @Override
	    public void deleteById(int id) {
	        customerRepository.deleteById(id);
	    }

}
