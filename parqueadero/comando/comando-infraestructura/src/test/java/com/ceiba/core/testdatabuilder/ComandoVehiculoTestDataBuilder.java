package com.ceiba.core.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.core.comando.ComandoVehiculo;

public class ComandoVehiculoTestDataBuilder {

	private String placa;
	private String tipo; 
	private int cilindraje;
	private String modelo;
	private String marca;	
    private LocalDateTime fechaIngreso;
    
    public ComandoVehiculoTestDataBuilder() {
    	placa = "abc123";
		tipo = "moto";
		cilindraje = 500;
		modelo = "y5";
		marca = "yamaha";
		fechaIngreso = LocalDateTime.now();
	}
    
    public ComandoVehiculoTestDataBuilder conMarca(String marca) {
    	this.marca = marca;
    	return this;
    }
    
    public ComandoVehiculo build() {
    	return new ComandoVehiculo(placa,tipo,cilindraje,modelo,marca,fechaIngreso);
    }
}
