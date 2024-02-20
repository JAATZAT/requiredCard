package com.tarea.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tarea.model.CreditCheck;
import com.tarea.service.ICreditCheckService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
@RequestMapping("api/credit")
public class CreditController {

	@Autowired
	private ICreditCheckService creditCheckService;

	@GetMapping("listCreditCheck")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> listCreditCheck() {
		return ResponseEntity.ok(creditCheckService.getAllCreditCheck());
	}

	// Obtener un CreditCheck por ID
	@GetMapping("/{id}")
	public ResponseEntity<?> getCreditCheckById(@PathVariable int id) {
		Optional<CreditCheck> creditCheckOptional = creditCheckService.findById(id);
		if (creditCheckOptional.isPresent()) {
			return ResponseEntity.ok(creditCheckOptional.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Crear un nuevo CreditCheck
	@PostMapping("/")
	public ResponseEntity<?> createCreditCheck(@RequestBody CreditCheck creditCheck) {
		return ResponseEntity.ok(creditCheckService.save(creditCheck));
	}

	// Actualizar un CreditCheck por ID
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCreditCheck(@PathVariable int id, @RequestBody CreditCheck creditCheck) {
		Optional<CreditCheck> creditCheckOptional = creditCheckService.findById(id);
		if (creditCheckOptional.isPresent()) {
			CreditCheck updatedCreditCheck = creditCheckOptional.get();
			updatedCreditCheck.setResultado(creditCheck.getResultado());
			updatedCreditCheck.setObservaciones(creditCheck.getObservaciones());
			updatedCreditCheck.setRequest(creditCheck.getRequest());
			return ResponseEntity.ok(creditCheckService.save(updatedCreditCheck));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Eliminar un CreditCheck por ID
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCreditCheck(@PathVariable int id) {
		creditCheckService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
