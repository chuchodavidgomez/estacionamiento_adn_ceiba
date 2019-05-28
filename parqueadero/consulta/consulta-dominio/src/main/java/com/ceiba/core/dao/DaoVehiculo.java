package com.ceiba.core.dao;

import java.util.List;

import com.ceiba.core.modelo.DtoVehiculo;

public interface DaoVehiculo {

	/**
	 * Permite listar usuarios
	 * @return los usuarios
	 */
	List<DtoVehiculo> listar();

}