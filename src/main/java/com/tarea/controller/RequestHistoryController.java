package com.tarea.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tarea.model.RequestHistory;
import com.tarea.service.IRequestHistoryService;

@Controller
@RequestMapping("/requestHistory")
public class RequestHistoryController {

	@Autowired
	private IRequestHistoryService requestHistoryService;
	
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	ResponseEntity<?> listRequestHistory(@PathVariable int solicitudID){
		List<?> rh = requestHistoryService.getAllRequestHistory();
		if (!rh.isEmpty()) {
	        return ResponseEntity.ok(rh);
	    }

	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron registros de historial para la solicitud " + solicitudID);
	}
	
	//
	 // Get a specific request history entry by its ID
    @GetMapping("/{historialID}")
    public ResponseEntity<?> getRequestHistoryById(@PathVariable int historialID) {
        Optional<?> rhOptional = requestHistoryService.findById(historialID);
        if (rhOptional.isPresent()) {
            return ResponseEntity.ok(rhOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el registro de historial con ID " + historialID);
        }
    }

    // Create a new request history entry
    @PostMapping("/")
    public ResponseEntity<?> createRequestHistory(@RequestBody RequestHistory requestHistory) {
        try {
            requestHistoryService.save(requestHistory);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Update an existing request history entry
    @PutMapping("/{historialID}")
    public ResponseEntity<?> updateRequestHistory(@PathVariable int historialID, @RequestBody RequestHistory requestHistory) {
        Optional<?> rhOptional = requestHistoryService.findById(historialID);
        if (rhOptional.isPresent()) {
            try {
                requestHistory.setHistorialID(historialID);
                requestHistoryService.update(requestHistory);
                return ResponseEntity.ok().build();
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete a request history entry by its ID
    @DeleteMapping("/{historialID}")
    public ResponseEntity<?> deleteRequestHistoryById(@PathVariable int historialID) {
        try {
            requestHistoryService.deleteById(historialID);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
