package com.ceiba.core.manejador;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.core.dao.DaoHistorial;
import com.ceiba.core.modelo.DtoHistorial;

@Component
public class ManejadorListarHistorial {
	
	private final DaoHistorial daoHistorial;
	
	public ManejadorListarHistorial(DaoHistorial daoHistorial) {
		this.daoHistorial = daoHistorial;		
	}
	
	public List<DtoHistorial> ejecutar(){
		return this.daoHistorial.listar();
	}
}
