package com.tarea.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarea.model.RequestHistory;
import com.tarea.repository.RequestHistoryRepository;
import com.tarea.service.IRequestHistoryService;

@Service
public class RequestHistoryServiceImpl implements IRequestHistoryService {

	@Autowired
	private RequestHistoryRepository requestHistoryRepository;

	@Override
	public List<RequestHistory> getAllRequestHistory() {
		List<RequestHistory> requestHistoryList = new ArrayList<>();
		RequestHistory history1 = new RequestHistory();
		history1.setFechaEstado(new Date());
		history1.setEstadoAnterior("En revisión");
		history1.setEstadoNuevo("Aprobado");

		RequestHistory history2 = new RequestHistory();
		history2.setFechaEstado(new Date());

		history2.setEstadoAnterior("Ingresado");
		history2.setEstadoNuevo("En revisión");

		// Add objects to the list
		requestHistoryList.add(history1);
		requestHistoryList.add(history2);
		return requestHistoryList;
	}

	@Override
	public List<?> getAllRequestHistoryBySolicitudID(int solicitudID) {
		return requestHistoryRepository.findAll();
	}

	@Override
	public Optional<?> findById(int historialID) {
		return requestHistoryRepository.findById(historialID);
	}

	@Override
	public void save(RequestHistory requestHistory) {
		requestHistoryRepository.save(requestHistory);
	}

	@Override
	public void update(RequestHistory requestHistory) {
		requestHistoryRepository.save(requestHistory);
	}

	@Override
	public void deleteById(int historialID) {
		requestHistoryRepository.deleteById(historialID);
	}
}
