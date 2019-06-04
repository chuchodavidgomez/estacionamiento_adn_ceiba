package com.ceiba.core.comando;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoHistorial {
	private Long id;
	private String placaVehiculo;
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	private double pago;
}
