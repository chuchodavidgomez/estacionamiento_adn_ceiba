package com.ceiba.core.modelo.usuario;

import static com.ceiba.core.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.core.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDateTime;

public class Vehiculo {
	
    private static final String SE_DEBE_INGRESAR_LA_FECHA_INGRESO = "Se debe ingresar la fecha de ingreso";
	private static final String LA_PLACA_DEBE_TENER_LONGITUD_IGUAL = "La placa debe tener una longitud igual a %s";
	private static final String SE_DEBE_INGRESAR_EL_TIPO = "Se debe ingresar el tipo";
	private static final String SE_DEBE_INGRESAR_LA_PLACA = "Se debe ingresar la placa";
	private static final String SE_DEBE_INGRESAR_EL_MODELO = "Se debe ingresar el modelo";
	private static final String SE_DEBE_INGRESAR_LA_MARCA = "Se debe ingresar la marca";
	
	private static final int LONGITUD_PLACA = 6;
    
	private String placa;
	private String tipo; 
	private int cilindraje;
	private String modelo;
	private String marca;	
    private LocalDateTime fechaIngreso;

    public Vehiculo(String placa, String tipo, int cilindraje, String modelo, String marca, LocalDateTime fechaIngreso) {
        validarObligatorio(placa, SE_DEBE_INGRESAR_LA_PLACA);
        validarLongitud(placa, LONGITUD_PLACA, String.format(LA_PLACA_DEBE_TENER_LONGITUD_IGUAL,LONGITUD_PLACA)); 
        validarObligatorio(tipo, SE_DEBE_INGRESAR_EL_TIPO);   
        validarObligatorio(modelo, SE_DEBE_INGRESAR_EL_MODELO);
        validarObligatorio(marca, SE_DEBE_INGRESAR_LA_MARCA);    
        validarObligatorio(fechaIngreso, SE_DEBE_INGRESAR_LA_FECHA_INGRESO);        

        this.placa = placa;
        this.tipo = tipo;
        this.cilindraje = cilindraje;
        this.modelo = modelo;
        this.marca = marca;
        this.fechaIngreso = fechaIngreso;
    }

    public String getPlaca() {
		return placa;
	}

    public String getTipo() {
        return tipo;
    }
    
    public int cilindraje() {
        return cilindraje;
    }
    
    public String modelo() {
        return modelo;
    }
    
    public String marca() {
        return marca;
    }
    
    public LocalDateTime getFechaCreacion() {
		return fechaIngreso;
	}
}
