package com.ceiba.core.servicio.usuario;

import com.ceiba.core.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.core.modelo.usuario.Vehiculo;
import com.ceiba.core.repositorio.RepositorioUsuario;

public class ServicioActualizarUsuario {
//revisar 
    private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";
    
	private final RepositorioUsuario repositorioUsuario;

    public ServicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public void ejecutar(Vehiculo usuario) {
    	validarExistenciaPrevia(usuario);
        this.repositorioUsuario.actualizar(usuario);
    }

	private void validarExistenciaPrevia(Vehiculo usuario) {
		boolean existe = this.repositorioUsuario.existeExcluyendoId(usuario.getPlaca(),usuario.getTipo());
    	if(existe) {
    		throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
    	}
	}
}
