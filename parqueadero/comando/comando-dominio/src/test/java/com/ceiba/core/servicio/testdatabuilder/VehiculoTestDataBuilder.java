package com.ceiba.core.servicio.testdatabuilder;

import com.ceiba.core.modelo.vehiculo.Vehiculo;

public class VehiculoTestDataBuilder {

	private String placa;
	private String tipo; 
	private int cilindraje;
	private String modelo;
	private String marca;	
    
    public VehiculoTestDataBuilder() {
		placa = "abc123";
		tipo = "auto";
		cilindraje = 500;
		modelo = "y5";
		marca = "yamaha";
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
    
    public Vehiculo build() {
    	return new Vehiculo(placa,tipo,cilindraje,modelo,marca);
    }
}
