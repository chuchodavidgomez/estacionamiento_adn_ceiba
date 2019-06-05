package com.ceiba.core.servicio.historial;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import com.ceiba.core.dominio.excepcion.ExcepcionDiaNoHabil;
import com.ceiba.core.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.core.dominio.excepcion.ExcepcionExcedeCantidad;
import com.ceiba.core.modelo.historial.Historial;
import com.ceiba.core.repositorio.RepositorioHistorial;

public class ServicioCrearHistorial {
	private static final String EL_HISTORIAL_YA_EXISTE_EN_EL_SISTEMA = "El historial ya existe en el sistema";
	private static final String NO_HAY_CUPOS_DISPONIBLES_PARA_MOTO = "No hay cupos disponibles para moto";
	private static final String NO_HAY_CUPOS_DISPONIBLES_PARA_AUTO = "No hay cupos disponibles para autos";
	private static final String NO_PUEDE_INGRESAR_DIA_NO_HABIL = "No puede ingresar, dia no habil";
	private static final String MOTO = "moto";
	private static final String LETRA_A = "a";
	
	private final RepositorioHistorial repositorioHistorial;
	
	public ServicioCrearHistorial(RepositorioHistorial repositorioHistorial) {
		this.repositorioHistorial = repositorioHistorial;
	}
	
	public Long ejecutar(Historial historial) {
		validarExistenciaPrevia(historial);
		validarCupos(historial);
		validarPlaca(historial.getPlaca());
		return this.repositorioHistorial.crear(historial);
	}
	
	private void validarExistenciaPrevia(Historial historial) {
		boolean existe = this.repositorioHistorial.existe(historial.getId());
    	if(existe) {
    		throw new ExcepcionDuplicidad(EL_HISTORIAL_YA_EXISTE_EN_EL_SISTEMA);
    	}
	}
	
	private void validarCupos(Historial historial) {
		String tipo = this.repositorioHistorial.devuelveTipo(historial.getPlaca());
		int cantidadVehiculos = this.repositorioHistorial.cantidadVehiculos(tipo);
		
		if(tipo.equals(MOTO)) {
			if(cantidadVehiculos>10) {
				throw new ExcepcionExcedeCantidad(NO_HAY_CUPOS_DISPONIBLES_PARA_MOTO);
			}
		}else {
			if(cantidadVehiculos>20) {
				throw new ExcepcionExcedeCantidad(NO_HAY_CUPOS_DISPONIBLES_PARA_AUTO);
			}
		}
	}
	
	private void validarPlaca(String placa) {
		if(validaPrimeraLetra(placa) && esLunesODomingo()) {
			throw new ExcepcionDiaNoHabil(NO_PUEDE_INGRESAR_DIA_NO_HABIL);
		}
	}
	
	private boolean validaPrimeraLetra(String placa) {
		String primeraLetra = placa.toLowerCase().charAt(0) + "";
		return primeraLetra.equals(LETRA_A);
	}
	
	private Boolean esLunesODomingo() {
		DayOfWeek dayOfToday = LocalDateTime.now().getDayOfWeek();
		return dayOfToday.equals(DayOfWeek.MONDAY) || dayOfToday.equals(DayOfWeek.SUNDAY);
	}
	
}
