package com.ceiba.core.modelo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoHistorial {

	private Long id;
	private String placaVehiculo;
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	private double pago;
}
