package com.ceiba.core.testdatabuilder;

import com.ceiba.core.comando.ComandoVehiculo;

public class ComandoVehiculoTestDataBuilder {

	private String placa;
	private String tipo; 
	private int cilindraje;
	private String modelo;
	private String marca;	

    
    public ComandoVehiculoTestDataBuilder() {
    	placa = "cdf457";
		tipo = "moto";
		cilindraje = 500;
		modelo = "y5";
		marca = "yamaha";
	}
    
    public ComandoVehiculoTestDataBuilder conMarca(String marca) {
    	this.marca = marca;
    	return this;
    }
    
    public ComandoVehiculoTestDataBuilder conPlaca(String placa) {
    	this.placa = placa;
    	return this;
    }
    
    public ComandoVehiculo build() {
    	return new ComandoVehiculo(placa,placa,tipo,cilindraje,modelo,marca);
    }
}
