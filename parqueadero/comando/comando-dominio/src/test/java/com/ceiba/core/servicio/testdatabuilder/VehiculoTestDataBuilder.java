package com.ceiba.core.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.core.modelo.usuario.Vehiculo;

public class VehiculoTestDataBuilder {

	private String placa;
	private String tipo; 
	private int cilindraje;
	private String modelo;
	private String marca;	
    private LocalDateTime fechaIngreso;
    
    public VehiculoTestDataBuilder() {
		placa = "abc123";
		tipo = "moto";
		cilindraje = 500;
		modelo = "y5";
		marca = "yamaha";
		fechaIngreso = LocalDateTime.now();
	}
    
    public VehiculoTestDataBuilder conPlaca(String placa) {
    	this.placa = placa;
    	return this;
    }
    
    public VehiculoTestDataBuilder conTipo(String tipo) {
    	this.tipo = tipo;
    	return this;
    }
    
    public VehiculoTestDataBuilder conCilindraje(int cilindraje) {
    	this.cilindraje = cilindraje;
    	return this;
    }
    
    public VehiculoTestDataBuilder conModelo(String modelo) {
    	this.modelo = modelo;    	
    	return this;
    }
    
    public VehiculoTestDataBuilder conMarca(String marca) {
    	this.marca = marca;
    	return this;
    }
    
    public VehiculoTestDataBuilder conFechaIngreso(LocalDateTime fechaIngreso) {
    	this.fechaIngreso = fechaIngreso;
    	return this;
    }
    
    
    public Vehiculo build() {
    	return new Vehiculo(placa,tipo,cilindraje,modelo,marca,fechaIngreso);
    }
}
