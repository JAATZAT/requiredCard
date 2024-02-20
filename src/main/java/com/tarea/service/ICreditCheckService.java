package com.tarea.service;

import java.util.List;
import java.util.Optional;

import com.tarea.model.CreditCheck;

public interface ICreditCheckService {

	List<CreditCheck> getAllCreditCheck();

	Optional<CreditCheck> findById(int id);

	CreditCheck save(CreditCheck creditCheck);

	void deleteById(int id);
}
