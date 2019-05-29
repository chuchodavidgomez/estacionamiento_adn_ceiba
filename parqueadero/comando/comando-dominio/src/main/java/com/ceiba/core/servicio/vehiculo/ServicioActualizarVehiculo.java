package com.ceiba.core.servicio.vehiculo;

import com.ceiba.core.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.core.modelo.vehiculo.Vehiculo;
import com.ceiba.core.repositorio.RepositorioVehiculo;

public class ServicioActualizarVehiculo {
 
    private static final String EL_VEHICULO_YA_EXISTE_EN_EL_SISTEMA = "El vehiculo ya existe en el sistema";
    
	private final RepositorioVehiculo repositorioVehiculo;

    public ServicioActualizarVehiculo(RepositorioVehiculo repositorioVehiculo) {
        this.repositorioVehiculo = repositorioVehiculo;
    }

    public void ejecutar(Vehiculo vehiculo) {
    	validarExistenciaPrevia(vehiculo);
        this.repositorioVehiculo.actualizar(vehiculo);
    }

	private void validarExistenciaPrevia(Vehiculo usuario) {
		boolean existe = this.repositorioVehiculo.existeExcluyendoPlaca(usuario.getPlaca(),usuario.getTipo());
    	if(existe) {
    		throw new ExcepcionDuplicidad(EL_VEHICULO_YA_EXISTE_EN_EL_SISTEMA);
    	}
	}
}
