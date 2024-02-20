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
import org.springframework.web.util.UriComponentsBuilder;

import com.tarea.model.Card;
import com.tarea.service.ICardService;
import com.tarea.service.impl.CardNotFoundException;
import com.tarea.service.impl.InvalidCardDataException;

@Controller
@RequestMapping("api/card")
public class CardController {

	@Autowired
	private ICardService cardService;
	
	@GetMapping("/toListCard")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listCard() {
        try {
            return ResponseEntity.ok(cardService.getAllCards());
        } catch (Exception e) {
            System.err.println("Error al obtener la lista de tarjetas: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getCardById(@PathVariable int id) {
        try {
            Card card = cardService.getCardById(id);
            return ResponseEntity.ok(card);
        } catch (CardNotFoundException e) {
            System.err.println("Tarjeta con ID " + id + " no encontrada.");
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            System.err.println("Error al obtener la tarjeta con ID " + id + ": " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createCard(@RequestBody Card card) {
        try {
            cardService.saveCard(card);
            URI location = UriComponentsBuilder.fromPath("/api/card/{id}")
                    .buildAndExpand(card.getTarjetaId()).toUri();
            return ResponseEntity.created(location).build();
        } catch (InvalidCardDataException e) {
            System.err.println("Datos de la tarjeta no válidos: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            System.err.println("Error al crear la tarjeta: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateCard(@PathVariable int id, @RequestBody Card card) {
        try {
            cardService.updateCard(id, card);
            return ResponseEntity.ok().build();
        } catch (CardNotFoundException e) {
            System.err.println("Tarjeta con ID " + id + " no encontrada.");
            return ResponseEntity.notFound().build();
        } catch (InvalidCardDataException e) {
            System.err.println("Datos de la tarjeta no válidos: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            System.err.println("Error al actualizar la tarjeta con ID " + id + ": " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteCard(@PathVariable int id) {
        try {
            cardService.deleteCardById(id);
            return ResponseEntity.noContent().build();
        } catch (CardNotFoundException e) {
            System.err.println("Tarjeta con ID " + id + " no encontrada.");
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            System.err.println("Error al eliminar la tarjeta con ID " + id + ": " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    private ResponseEntity<?> handleCardNotFoundException(int id) {
        System.err.println("Tarjeta con ID " + id + " no encontrada.");
        return ResponseEntity.notFound().build();
    }

    private ResponseEntity<?> handleGeneralException(String message, Exception e) {
        // Log the exception using a logging framework
        System.err.println(message + ": " + e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
