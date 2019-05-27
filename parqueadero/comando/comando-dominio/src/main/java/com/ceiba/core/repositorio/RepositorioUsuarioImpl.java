package com.ceiba.core.repositorio;

import org.springframework.stereotype.Component;

import com.ceiba.core.modelo.usuario.Usuario;

@Component
public class RepositorioUsuarioImpl implements RepositorioUsuario {

	@Override
	public Long crear(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Usuario usuario) {
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
	public boolean existeExcluyendoId(Long id, String nombre) {
		// TODO Auto-generated method stub
		return false;
	}

}
