package com.ceiba.core.servicio.historial;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import com.ceiba.core.dominio.excepcion.ExcepcionDiaNoHabil;
import com.ceiba.core.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.core.dominio.excepcion.ExcepcionEstaParqueado;
import com.ceiba.core.dominio.excepcion.ExcepcionExcedeCantidad;
import com.ceiba.core.modelo.historial.Historial;
import com.ceiba.core.repositorio.RepositorioHistorial;

public class ServicioCrearHistorial {
	private static final String EL_HISTORIAL_YA_EXISTE_EN_EL_SISTEMA = "El historial ya existe en el sistema";
	private static final String NO_HAY_CUPOS_DISPONIBLES_PARA_MOTO = "No hay cupos disponibles para moto";
	private static final String NO_HAY_CUPOS_DISPONIBLES_PARA_AUTO = "No hay cupos disponibles para autos";
	private static final String NO_PUEDE_INGRESAR_DIA_NO_HABIL = "No puede ingresar, dia no habil";
	private static final String El_VEHICULO_YA_ESTA_PARQUEADO = "El vehiculo ya esta parqueado";
	private static final String MOTO = "moto";
	private static final String AUTO = "auto";
	private static final String LETRA_A = "a";
	private static final Integer NUMERO_MAXIMO_AUTO = 20;
	private static final Integer NUMERO_MAXIMO_MOTO = 10;
	
	private final RepositorioHistorial repositorioHistorial;
	
	public ServicioCrearHistorial(RepositorioHistorial repositorioHistorial) {
		
		this.repositorioHistorial = repositorioHistorial;
	}
	
	public Long ejecutar(Historial historial) {
		LocalDateTime fechaIngreso = historial.getFechaIngreso(); 
    	if(historial.getFechaSalida() == null) {
    		fechaIngreso = LocalDateTime.now(); 
    	} 
		validarExistenciaPrevia(historial);
		validarCupos(historial);
		validarPlaca(historial.getPlaca(), LocalDateTime.now().getDayOfWeek());
		validarParqueado(historial.getPlaca());
		return this.repositorioHistorial.crearHistorial(new Historial(historial.getId(),historial.getPlaca(),fechaIngreso,historial.getFechaSalida(),historial.getPago()));
	}
	
	private void validarParqueado(String placa) {
		boolean estaParqueado = this.repositorioHistorial.estaParqueado(placa);
		if(estaParqueado) {
			throw new ExcepcionEstaParqueado(El_VEHICULO_YA_ESTA_PARQUEADO);
		}
		
	}
	
	private void validarExistenciaPrevia(Historial historial) {
		boolean existe = this.repositorioHistorial.existeHistorial(historial.getId());
    	if(existe) {
    		throw new ExcepcionDuplicidad(EL_HISTORIAL_YA_EXISTE_EN_EL_SISTEMA);
    	}
	}
	
	private void validarCupos(Historial historial) {		
		String tipo = devuelveTipoDeVehiculo(historial.getPlaca());
		int cantidadVehiculos = this.repositorioHistorial.cantidadVehiculos(tipo);
		
		if(tipo.equals(MOTO)) {
			if(cantidadVehiculos > NUMERO_MAXIMO_MOTO) {
				throw new ExcepcionExcedeCantidad(NO_HAY_CUPOS_DISPONIBLES_PARA_MOTO);
			}
		}else {
			if(cantidadVehiculos > NUMERO_MAXIMO_AUTO) {
				throw new ExcepcionExcedeCantidad(NO_HAY_CUPOS_DISPONIBLES_PARA_AUTO);
			}
		}
	}
		
	public void validarPlaca(String placa, DayOfWeek dayOfToday) {
		if(validaPrimeraLetra(placa) && esLunesODomingo(dayOfToday)) {
			throw new ExcepcionDiaNoHabil(NO_PUEDE_INGRESAR_DIA_NO_HABIL);
		}
	}
	
	public String devuelveTipoDeVehiculo(String placa) {
		char ultimoDigito = placa.charAt(placa.length()-1);
		if(Character.isDigit(ultimoDigito)) {
			return AUTO;
		}else {
			return MOTO;
		}
	}
	
	public boolean validaPrimeraLetra(String placa) {
		String primeraLetra = placa.toLowerCase().charAt(0) + "";
		return primeraLetra.equals(LETRA_A);
	}
	
	public Boolean esLunesODomingo(DayOfWeek dayOfToday) {		
		return dayOfToday.equals(DayOfWeek.MONDAY) || dayOfToday.equals(DayOfWeek.SUNDAY);
	}
	
}
