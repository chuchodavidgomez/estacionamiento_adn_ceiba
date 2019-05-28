package com.ceiba.core.modelo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoVehiculo {

	private String placa;
	private String tipo; 
	private int cilindraje;
	private String modelo;
	private String marca;	
    private LocalDateTime fechaIngreso;
}
