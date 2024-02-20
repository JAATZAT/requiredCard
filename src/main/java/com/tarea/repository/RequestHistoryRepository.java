package com.tarea.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.tarea.model.RequestHistory;

@Repository
public interface RequestHistoryRepository {
	List<RequestHistory> findBySolicitudID(int solicitudID);
	List<RequestHistory> findByEstado(String estado);
	List<RequestHistory> findByFechaEstadoBetween(Date fechaInicio, Date fechaFin);
	List<RequestHistory> findBySolicitudIDAndEstado(int solicitudID, String estado);
	long countBySolicitudID(int solicitudID);
	boolean existsBySolicitudIDAndEstado(int solicitudID, String estado);
	List<?> findAll();
	Optional<?> findById(int historialID);
	void save(RequestHistory requestHistory);
	void deleteById(int historialID);


}
