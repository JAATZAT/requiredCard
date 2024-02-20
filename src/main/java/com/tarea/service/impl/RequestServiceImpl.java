package com.tarea.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarea.model.Card;
import com.tarea.model.Customer;
import com.tarea.model.Request;
import com.tarea.repository.RequestRepository;
import com.tarea.service.IRequestService;

@Service
public class RequestServiceImpl implements IRequestService {
	
	@Autowired
	private RequestRepository requestRepository;

	@Override
	public List<Request> getAll() {
		List<Request> requestList = new ArrayList<>();
		Request request1 = new Request();
		request1.setSolicitudID(1);
		request1.setFechaSolicitud(new Date());
		request1.setEstado("Pendiente");
		Customer customer1 = new Customer();
		customer1.setClienteID(1);
		customer1.setNombre("Juan");
		customer1.setApellido("Pérez");
		customer1.setDireccion("Calle 123");
		customer1.setTelefono("555-1234");
		customer1.setEmail("juan.perez@example.com");
		customer1.setIngresos(50000.00);
		customer1.setHistorialCrediticio("Bueno");
		request1.setCustomer(customer1);
		Card card1 = new Card();
		card1.setTarjetaId(1);
		card1.setNumeroTrjt("1234567890123456");
		card1.setTipoTrjt("VISA");
		card1.setLimiteCredito(10000.00);
		card1.setTasaInteres(0.15);
		request1.setCard(card1);
		requestList.add(request1);

		Request request2 = new Request();
		request2.setSolicitudID(2);
		request2.setFechaSolicitud(new Date());
		request2.setEstado("Aprobado");
		Customer customer2 = new Customer();
		customer2.setClienteID(2);
		customer2.setNombre("María");
		customer2.setApellido("González");
		customer2.setDireccion("Avenida 456");
		customer2.setTelefono("555-5678");
		customer2.setEmail("maria.gonzalez@example.com");
		customer2.setIngresos(75000.00);
		customer2.setHistorialCrediticio("Excelente");
		request2.setCustomer(customer2);
		Card card2 = new Card();
		card2.setTarjetaId(2);
		card2.setNumeroTrjt("9876543210987654");
		card2.setTipoTrjt("Mastercard");
		card2.setLimiteCredito(15000.00);
		card2.setTasaInteres(0.12);
		request2.setCard(card2);
		requestList.add(request2);
		return requestList;
	}

	@Override
	public Request getRequestById(int id) {
	    Optional<Request> optionalRequest = Optional.empty(); 

	    if (optionalRequest.isPresent()) {
	        return optionalRequest.get();
	    } else {
	        return null;  
	    }
	}
	@Override
	public void createRequest(Request request) {
        requestRepository.save(request);

	}

	@Override
	public void updateRequest(Request request) {
        requestRepository.save(request);
		
	}

	@Override
	public void deleteRequest(int id) {
        requestRepository.deleteById(id);
		
	}

	
}
