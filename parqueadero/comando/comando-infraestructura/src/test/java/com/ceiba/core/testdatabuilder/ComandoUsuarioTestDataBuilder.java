package com.ceiba.core.testdatabuilder;

import java.time.LocalDateTime;
import java.util.UUID;

import com.ceiba.core.comando.ComandoVehiculo;

public class ComandoUsuarioTestDataBuilder {

	private Long id;
    private String nombre;
    private String clave;
    private LocalDateTime fecha;
    
    public ComandoUsuarioTestDataBuilder() {
		nombre = UUID.randomUUID().toString();
		clave = "1234";
		fecha = LocalDateTime.now();
	}
    
    public ComandoUsuarioTestDataBuilder conNombre(String nombre) {
    	this.nombre = nombre;
    	return this;
    }
    
    public ComandoVehiculo build() {
    	return new ComandoVehiculo(id,nombre, clave,fecha);
    }
}
