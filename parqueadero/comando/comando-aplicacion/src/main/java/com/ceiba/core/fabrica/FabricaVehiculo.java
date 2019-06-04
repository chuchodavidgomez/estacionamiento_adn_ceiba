package com.ceiba.core.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.core.comando.ComandoVehiculo;
import com.ceiba.core.modelo.vehiculo.Vehiculo;

@Component
public class FabricaVehiculo {
	
	public Vehiculo crear(ComandoVehiculo comandoUsuario) {
	    return new Vehiculo(
	    	comandoUsuario.getPlaca(),
	        comandoUsuario.getTipo(),
	        comandoUsuario.getCilindraje(),
	        comandoUsuario.getModelo(),
	        comandoUsuario.getMarca()
	    );
	}

}
