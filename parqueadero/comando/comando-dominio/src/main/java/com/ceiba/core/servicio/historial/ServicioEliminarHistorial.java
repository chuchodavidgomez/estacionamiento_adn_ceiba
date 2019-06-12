package com.ceiba.core.servicio.historial;

import com.ceiba.core.repositorio.RepositorioHistorial;

public class ServicioEliminarHistorial {
	private final RepositorioHistorial repositorioHistorial;
	
	public ServicioEliminarHistorial(RepositorioHistorial repositorioHistorial) {
		this.repositorioHistorial = repositorioHistorial; 
	}
	
	public void ejecutar(Long id) {
		repositorioHistorial.eliminarHistorial(id);
	}
}
