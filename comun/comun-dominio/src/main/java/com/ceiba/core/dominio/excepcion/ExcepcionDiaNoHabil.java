package com.ceiba.core.dominio.excepcion;

public class ExcepcionDiaNoHabil extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionDiaNoHabil(String mensaje) {
        super(mensaje);
    }
}
