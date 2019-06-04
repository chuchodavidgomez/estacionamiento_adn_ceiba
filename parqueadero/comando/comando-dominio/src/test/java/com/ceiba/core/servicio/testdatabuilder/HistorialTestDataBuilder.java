package com.ceiba.core.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.core.modelo.historial.Historial;

public class HistorialTestDataBuilder {
	private Long id;
	private String placaVehiculo; 
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	private double precio;	
    
    public HistorialTestDataBuilder() {	
		placaVehiculo = "aaabbb";
		fechaIngreso = LocalDateTime.now();
		fechaSalida = LocalDateTime.now().plusDays(1);
		precio = 10000;
	}
       
    public HistorialTestDataBuilder conPlacaVehiculo(String tipo) {
    	this.placaVehiculo = tipo;
    	return this;
    }
    
    public HistorialTestDataBuilder conFechaIngreso(LocalDateTime fechaIngreso) {
    	this.fechaIngreso = fechaIngreso;
    	return this;
    }
    
    public HistorialTestDataBuilder conFechaSalida(LocalDateTime fechaSalida) {
    	this.fechaSalida = fechaSalida;    	
    	return this;
    }
    
    public HistorialTestDataBuilder conPrecio(double precio) {
    	this.precio = precio;
    	return this;
    }
    
    public Historial build() {
    	return new Historial(id,placaVehiculo,fechaIngreso,fechaSalida,precio);
    }
}
