package com.ceiba.core.servicio.vehiculo;

import com.ceiba.core.dominio.excepcion.ExcepcionNoExistencia;
import com.ceiba.core.modelo.vehiculo.Vehiculo;
import com.ceiba.core.repositorio.RepositorioVehiculo;

public class ServicioActualizarVehiculo {
     
	private final RepositorioVehiculo repositorioVehiculo;
	private static final String EL_VEHICULO_NO_EXISTE_EN_EL_SISTEMA = "El vehiculo no existe en el sistema";

    public ServicioActualizarVehiculo(RepositorioVehiculo repositorioVehiculo) {
        this.repositorioVehiculo = repositorioVehiculo;
    }

    public void ejecutar(Vehiculo vehiculo) {    	
    	validarExistencia(vehiculo);
        this.repositorioVehiculo.actualizar(vehiculo);
    }
    
    private void validarExistencia(Vehiculo usuario) {
		boolean existe = this.repositorioVehiculo.existe(usuario.getPlaca());
    	if(!existe) {
    		throw new ExcepcionNoExistencia(EL_VEHICULO_NO_EXISTE_EN_EL_SISTEMA);
    	}
	}
}
