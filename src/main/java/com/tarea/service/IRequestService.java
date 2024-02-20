package com.tarea.service;

import java.util.List;

import com.tarea.model.Request;

public interface IRequestService {

	public List<Request> getAll();

	public Request getRequestById(int id);
	
	void createRequest(Request request);
	
	void updateRequest(Request request);
	
	void deleteRequest(int id);

	
}
