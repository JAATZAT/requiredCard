package com.tarea.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_Request")

//CLASE DE SOLICITUD DE TARJETAS
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int solicitudID;
	private Date fechaSolicitud;
	private String estado;

	@ManyToOne
	@JoinColumn(name = "clienteID")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "tarjetaID")
	private Card card;

	// Otras propiedades y relaciones
}
