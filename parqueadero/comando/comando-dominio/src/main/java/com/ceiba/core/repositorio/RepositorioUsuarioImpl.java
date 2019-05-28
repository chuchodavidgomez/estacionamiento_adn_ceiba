package com.ceiba.core.repositorio;

import org.springframework.stereotype.Component;

import com.ceiba.core.modelo.usuario.Vehiculo;

@Component
public class RepositorioUsuarioImpl implements RepositorioUsuario {

	@Override
	public Long crear(Vehiculo usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Vehiculo usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean existe(String nombre) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeExcluyendoId(String id, String nombre) {
		// TODO Auto-generated method stub
		return false;
	}

}
