package com.tarea.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tarea.repository.RequestHistoryRepository;
import com.tarea.service.impl.RequestHistoryServiceImpl;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

	private final RequestHistoryRepository requestHistoryRepository;

	/*@Bean
	public RequestHistoryRepository requestHistoryRepository() {
		return new RequestHistoryRepositoryImpl(); // Reemplaza esto con tu implementación real
	}*/

}
