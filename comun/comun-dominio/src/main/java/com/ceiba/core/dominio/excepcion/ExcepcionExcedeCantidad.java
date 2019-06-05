package com.ceiba.core.dominio.excepcion;

public class ExcepcionExcedeCantidad extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ExcepcionExcedeCantidad (String mensaje) {
        super(mensaje);
    }
}
