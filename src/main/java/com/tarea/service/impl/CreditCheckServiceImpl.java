package com.tarea.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarea.model.CreditCheck;
import com.tarea.repository.CreditCheckRepository;
import com.tarea.service.ICreditCheckService;

@Service
public class CreditCheckServiceImpl implements ICreditCheckService {

	@Autowired
	private CreditCheckRepository creditCheckRepository;

	@Override
	public List<CreditCheck> getAllCreditCheck() {
		List<CreditCheck> creditCheckList = new ArrayList<>();
		CreditCheck check1 = new CreditCheck();
		check1.setResultado("Aprobado");
		check1.setObservaciones("Sin observaciones");

		CreditCheck check2 = new CreditCheck();
		check2.setResultado("Denegado");
		check2.setObservaciones("Morosidad en pagos anteriores");

		// Agregar los objetos a la lista
		creditCheckList.add(check1);
		creditCheckList.add(check2);

		return creditCheckList;
	}

	@Override
	public Optional<CreditCheck> findById(int id) {

		return creditCheckRepository.findById(id);
	}

	@Override
	public CreditCheck save(CreditCheck creditCheck) {

		return creditCheckRepository.save(creditCheck);
	}

	@Override
	public void deleteById(int id) {
        creditCheckRepository.deleteById(id);

	}

}
