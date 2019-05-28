package com.ceiba.core.comando;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoVehiculo{
	private String placa;
	private String tipo; 
	private int cilindraje;
	private String modelo;
	private String marca;	
    private LocalDateTime fechaIngreso;
}
