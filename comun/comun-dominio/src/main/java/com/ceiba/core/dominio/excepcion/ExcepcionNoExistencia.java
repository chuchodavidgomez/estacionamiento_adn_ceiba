package com.ceiba.core.dominio.excepcion;

public class ExcepcionNoExistencia extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionNoExistencia(String message) {
        super(message);
    }
}
