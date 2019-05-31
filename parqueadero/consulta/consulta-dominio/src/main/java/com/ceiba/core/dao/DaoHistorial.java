package com.ceiba.core.dao;

import java.util.List;

import com.ceiba.core.modelo.DtoHistorial;

public interface DaoHistorial {
	
	/**
	 * Permite listar usuarios
	 * @return los usuarios
	 */
	List<DtoHistorial> listar();
}
