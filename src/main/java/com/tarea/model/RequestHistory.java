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
@Table(name = "TB_RequestHistory")

//CLASE DE HISTORIAL DE SOLICITUDES
public class RequestHistory {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int historialID;
    private Date fechaEstado;
    private String estadoAnterior;
    private String estadoNuevo;

    @ManyToOne
    @JoinColumn(name = "solicitudID")
    private Request request;
	
}
