package com.ceiba.core.servicio.historial;

import com.ceiba.core.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.core.modelo.historial.Historial;
import com.ceiba.core.repositorio.RepositorioHistorial;

public class ServicioCrearHistorial {
	private static final String EL_HISTORIAL_YA_EXISTE_EN_EL_SISTEMA = "El historial ya existe en el sistema";
	RepositorioHistorial repositorioHistorial;
	
	public ServicioCrearHistorial(RepositorioHistorial repositorioHistorial) {
		this.repositorioHistorial = repositorioHistorial;
	}
	
	public Long ejecutar(Historial historial) {
		validarExistenciaPrevia(historial);
		return this.repositorioHistorial.crear(historial);
	}
	
	private void validarExistenciaPrevia(Historial historial) {
		boolean existe = this.repositorioHistorial.existe(historial.getId());
    	if(existe) {
    		throw new ExcepcionDuplicidad(EL_HISTORIAL_YA_EXISTE_EN_EL_SISTEMA);
    	}
	}
}
