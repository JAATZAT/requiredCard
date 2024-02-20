package com.tarea.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarea.model.Card;

public interface CardRepository extends JpaRepository<Card, Integer> {

	Optional<Card> findById(int id);

    
}
