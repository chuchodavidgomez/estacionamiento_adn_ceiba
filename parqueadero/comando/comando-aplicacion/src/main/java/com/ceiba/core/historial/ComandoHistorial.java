package com.ceiba.core.historial;

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
	private String placa;
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	private double pago;
}
