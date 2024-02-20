package com.tarea.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tarea.model.Request;
import com.tarea.service.IRequestService;

@Controller
@RequestMapping("api/request")
public class RequestController {

	@Autowired
	private IRequestService requestService;

	// VER LA LISTA DE LAS SOLICITUDES
	@GetMapping("/listRequest")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> listRequest() {
		return ResponseEntity.ok(requestService.getAll());
	}

	// OBTENER UNA SOLICITUD
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getRequestById(@PathVariable int id) {
	    Request request = requestService.getRequestById(id);

	    if (request == null) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(request);
	    }
	}

	// CREAR UNA NUEVA SOLICITUD
	@PostMapping
	public ResponseEntity<?> createRequest(@RequestBody Request request) {
		requestService.createRequest(request);
		return ResponseEntity.created(URI.create("/api/requests/" + request.getSolicitudID())).build();
	}

	// ACTUALIZR UNA SOLICITUD
	@PutMapping("/{id}")
	public ResponseEntity<?> updateRequest(@PathVariable int id, @RequestBody Request requestDetails) {
		Request request = requestService.getRequestById(id);
		if (request == null) {
			return ResponseEntity.notFound().build();
		}
		request.setFechaSolicitud(requestDetails.getFechaSolicitud());
		request.setEstado(requestDetails.getEstado());
		request.setCustomer(requestDetails.getCustomer());
		request.setCard(requestDetails.getCard());
		requestService.updateRequest(request);
		return ResponseEntity.ok(request);
	}

	//ELIMINAR UNA SOLICITUD
	@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRequest(@PathVariable int id) {
        requestService.deleteRequest(id);
        return ResponseEntity.noContent().build();
    }
}
