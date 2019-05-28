package com.ceiba.core.repositorio;

import org.springframework.stereotype.Component;

import com.ceiba.core.modelo.usuario.Vehiculo;

@Component
public class RepositorioVehiculoImpl implements RepositorioVehiculo {

	@Override
	public void crear(Vehiculo usuario) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void actualizar(Vehiculo usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean existe(String nombre) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existeExcluyendoPlaca(String placa, String marca) {
		// TODO Auto-generated method stub
		return false;
	}

}
