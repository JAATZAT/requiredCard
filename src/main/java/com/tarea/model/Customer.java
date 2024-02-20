package com.tarea.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "TB_Customer")

//CLASE DE CLIENTE
public class Customer {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clienteID;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String email;
    private double ingresos;
    private String historialCrediticio;
}
