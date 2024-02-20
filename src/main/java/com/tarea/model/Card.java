package com.tarea.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_Card")

//CLASE DE TARJETA
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tarjetaId;
	private String numeroTrjt;
	private String tipoTrjt;
	private double limiteCredito;
	private double tasaInteres;

}
