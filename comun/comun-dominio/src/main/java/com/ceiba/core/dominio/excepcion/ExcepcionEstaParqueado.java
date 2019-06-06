package com.ceiba.core.dominio.excepcion;

public class ExcepcionEstaParqueado extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ExcepcionEstaParqueado (String mensaje) {
        super(mensaje);
    }
}

