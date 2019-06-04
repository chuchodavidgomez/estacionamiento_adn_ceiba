package com.ceiba.core.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.core.modelo.historial.Historial;

public class ComandoHistorialTestDataBuilder {
	private Long id;
	private String placaVehiculo; 
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	private double precio;	
    
    public ComandoHistorialTestDataBuilder() {	
		placaVehiculo = "aaabbb";
		fechaIngreso = LocalDateTime.now();
		fechaSalida = LocalDateTime.now().plusDays(1);
		precio = 10000;
	}
       
    public ComandoHistorialTestDataBuilder conPlacaVehiculo(String tipo) {
    	this.placaVehiculo = tipo;
    	return this;
    }
    
    public ComandoHistorialTestDataBuilder conFechaIngreso(LocalDateTime fechaIngreso) {
    	this.fechaIngreso = fechaIngreso;
    	return this;
    }
    
    public ComandoHistorialTestDataBuilder conFechaSalida(LocalDateTime fechaSalida) {
    	this.fechaSalida = fechaSalida;    	
    	return this;
    }
    
    public ComandoHistorialTestDataBuilder conPrecio(double precio) {
    	this.precio = precio;
    	return this;
    }
    
    public Historial build() {
    	return new Historial(id,placaVehiculo,fechaIngreso,fechaSalida,precio);
    }
}
