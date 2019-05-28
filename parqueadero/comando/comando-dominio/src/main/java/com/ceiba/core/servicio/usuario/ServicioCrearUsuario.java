package com.ceiba.core.servicio.usuario;

import com.ceiba.core.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.core.modelo.usuario.Vehiculo;
import com.ceiba.core.repositorio.RepositorioUsuario;


//revisar comando
public class ServicioCrearUsuario {

    private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";
    
	private final RepositorioUsuario repositorioUsuario;

    public ServicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Long ejecutar(Vehiculo usuario) {
    	validarExistenciaPrevia(usuario);
        return this.repositorioUsuario.crear(usuario);
    }

	private void validarExistenciaPrevia(Vehiculo usuario) {
		boolean existe = this.repositorioUsuario.existe(usuario.getPlaca());
    	if(existe) {
    		throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
    	}
	}
}
