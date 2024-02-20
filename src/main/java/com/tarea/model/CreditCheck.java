package com.tarea.model;

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
@Table(name = "TB_CreditCheck")

//CLASE DE VERIFICACION DE CREDITO
public class CreditCheck {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int verificacionID;
    private String resultado;
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "solicitudID")
    private Request request;
   
}
