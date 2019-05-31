package com.ceiba.core.servicio.historial;

import com.ceiba.core.modelo.historial.Historial;
import com.ceiba.core.repositorio.RepositorioHistorial;

public class ServicioActualizarHistorial {
   
	private final RepositorioHistorial repositorioHistorial;

    public ServicioActualizarHistorial(RepositorioHistorial repositorioHistorial) {
        this.repositorioHistorial = repositorioHistorial;
    }

    public void ejecutar(Historial historial) {    	
        this.repositorioHistorial.actualizar(historial);
    }
}
