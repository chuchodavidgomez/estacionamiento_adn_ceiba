package com.ceiba.core.servicio.historial;

import java.time.LocalDateTime;
import java.time.ZoneId;

import com.ceiba.core.modelo.historial.Historial;
import com.ceiba.core.repositorio.RepositorioHistorial;

public class ServicioActualizarHistorial {
	private static final double VALOR_HORA_AUTO = 1000;
	private static final double VALOR_HORA_MOTO = 500;
	private static final double VALOR_DIA_AUTO = 8000;
	private static final double VALOR_DIA_MOTO = 4000;
	private static final double VALOR_CILINDRAJE = 2000;
	private static final double MINIMAS_HORAS = 9;
	private static final int HORAS_DIA = 24;
	private static final int CILINDRAJE_MAXIMO = 500;
	private static final String MOTO = "moto";
	private static final String AUTO = "auto";
	
	private final RepositorioHistorial repositorioHistorial;

    public ServicioActualizarHistorial(RepositorioHistorial repositorioHistorial) {
        this.repositorioHistorial = repositorioHistorial;
    }

    public void ejecutar(Historial historial) {    	    	
    	LocalDateTime fechaSalida = LocalDateTime.now();    	
    	Double pago = calcularPago(historial.getFechaIngreso(),fechaSalida,historial.getPlaca()); 
        this.repositorioHistorial.actualizar(new Historial(historial.getId(),historial.getPlaca(),historial.getFechaIngreso(),fechaSalida,pago));
    }
    
    public Double calcularPago(LocalDateTime fechaIngreso, LocalDateTime fechaSalida, String placa) {
    	double pago = 0;
    	
    	int cilindraje = this.repositorioHistorial.devuelveCilindraje(placa);
		//String tipo = this.repositorioHistorial.devuelveTipo(placa);	
    	String tipo = devuelveTipoDeVehiculo(placa);
		int horas = obtenerHorasTrascurridas(fechaIngreso, fechaSalida);
		
		if(tipo.equals(MOTO)) {
			
			if(cilindraje > CILINDRAJE_MAXIMO) {
				pago = pago + VALOR_CILINDRAJE;
			}
			
			if(horas < MINIMAS_HORAS) {				
				return pago + (VALOR_HORA_MOTO*horas);						
			}else if(horas <= HORAS_DIA) {
				return pago + VALOR_DIA_MOTO;
			}else {
				int dias = (horas / HORAS_DIA);
				horas = horas % HORAS_DIA;
				if(horas < MINIMAS_HORAS) {
					pago = pago + (horas*VALOR_HORA_MOTO);
				}else {
					pago = pago + VALOR_DIA_MOTO;
				}
				
				pago = pago + (dias*VALOR_DIA_MOTO);
				
				return pago;
			}
			
		}else {
			
			if(horas < MINIMAS_HORAS) {				
				return pago + (VALOR_HORA_AUTO*horas);						
			}
			else if(horas <= HORAS_DIA) {
				return pago + VALOR_DIA_AUTO;
			}else {
				int dias = (horas / HORAS_DIA);
				horas = horas % HORAS_DIA;
				if(horas < MINIMAS_HORAS) {
					pago = pago + (horas*VALOR_HORA_AUTO);
				}else {
					pago = pago + VALOR_DIA_AUTO;
				}
				
				pago = pago + (dias*VALOR_DIA_AUTO);
				
				return pago;
			}
			
		}
					
    }
    
    public int obtenerHorasTrascurridas(LocalDateTime fechaIngreso,LocalDateTime fechaSalida) {
    	
    	long segundos = (fechaSalida.atZone(ZoneId.of("America/Bogota")).toInstant().toEpochMilli() - fechaIngreso.atZone(ZoneId.of("America/Bogota")).toInstant().toEpochMilli()) / 1000;
		int horas = (int) (segundos / 3600);    
		segundos = segundos % 3600;
		int minutos = (int) (segundos / 60);
		
		if(minutos>0) {
			horas++;
			return horas;
		}
		
		segundos = segundos % 60;
		
		if(segundos>0 && horas==0) {
			horas++;
			return horas;
		}
		return horas;
    }
    
    public String devuelveTipoDeVehiculo(String placa) {
		char ultimoDigito = placa.charAt(placa.length()-1);
		if(Character.isDigit(ultimoDigito)) {
			return AUTO;
		}else {
			return MOTO;
		}
	}
		
}
