package com.tarea.service;

import java.util.List;
import java.util.Optional;

import com.tarea.model.RequestHistory;

public interface IRequestHistoryService {
	List<?> getAllRequestHistory();

    List<?> getAllRequestHistoryBySolicitudID(int solicitudID);

    Optional<?> findById(int historialID);

    void save(RequestHistory requestHistory);

    void update(RequestHistory requestHistory);

    void deleteById(int historialID);

}
