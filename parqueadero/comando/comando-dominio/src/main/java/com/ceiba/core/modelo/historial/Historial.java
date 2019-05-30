package com.ceiba.core.modelo.historial;

import static com.ceiba.core.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDateTime;

public class Historial {
	
	private static final String SE_DEBE_INGRESAR_LA_PLACA = "Se debe ingresar la placa";
	
	private Long id;
	private String placa;
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	private double pago;
	
	public Historial(Long id, String placa, LocalDateTime fechaIngreso, LocalDateTime fechaSalida, double pago) {
		validarObligatorio(placa, SE_DEBE_INGRESAR_LA_PLACA);
		this.id = id;
		this.placa = placa;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.pago = pago;		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}
	
	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}
	
	public double getPago() {
		return pago;
	}
}
