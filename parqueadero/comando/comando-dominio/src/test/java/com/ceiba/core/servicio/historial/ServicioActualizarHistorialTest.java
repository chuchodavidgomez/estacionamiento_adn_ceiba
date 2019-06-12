package com.ceiba.core.servicio.historial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.core.repositorio.RepositorioHistorial;

public class ServicioActualizarHistorialTest {
	@Test
	public void obtenerHorasTranscurridas24HorasTest() {
		//arrange
		LocalDateTime fechaInicial = LocalDateTime.now();
		LocalDateTime fechaSalida = LocalDateTime.now().plusDays(1);
    	RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
		ServicioActualizarHistorial servicioActualizarHistorial = new ServicioActualizarHistorial(repositorioHistorial);
		//act
		int horas = servicioActualizarHistorial.obtenerHorasTrascurridas(fechaInicial, fechaSalida);
		
		//assert
		assertEquals(horas,24);		
	}
	
	@Test
	public void obtenerHorasTranscurridas5SegundosTest() {
		//arrange
    	RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
		ServicioActualizarHistorial servicioActualizarHistorial = new ServicioActualizarHistorial(repositorioHistorial);
		//act
		int horas = servicioActualizarHistorial.obtenerHorasTrascurridas(LocalDateTime.now(), LocalDateTime.now().plusSeconds(5));
		
		//assert
		assertEquals(horas,1);		
	}
	
	@Test
	public void obtenerHorasTranscurridas7HorasTest() {
		//arrange
    	RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
		ServicioActualizarHistorial servicioActualizarHistorial = new ServicioActualizarHistorial(repositorioHistorial);
		//act
		int horas = servicioActualizarHistorial.obtenerHorasTrascurridas(LocalDateTime.now(), LocalDateTime.now().plusHours(7));
		
		//assert
		assertEquals(horas,7);		
	}
	
	@Test
	public void obtenerHorasTranscurridas7Horas5MinutosTest() {
		//arrange
    	RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
		ServicioActualizarHistorial servicioActualizarHistorial = new ServicioActualizarHistorial(repositorioHistorial);
		//act
		int horas = servicioActualizarHistorial.obtenerHorasTrascurridas(LocalDateTime.now(), LocalDateTime.now().plusHours(7).plusMinutes(5));
		
		//assert
		assertEquals(horas,8);		
	}
	
	@Test
	public void obtenerHorasTranscurridas0SegundosTest() {
		//arrange
    	RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
		ServicioActualizarHistorial servicioActualizarHistorial = new ServicioActualizarHistorial(repositorioHistorial);
		//act
		int horas = servicioActualizarHistorial.obtenerHorasTrascurridas(LocalDateTime.now(), LocalDateTime.now());
		
		//assert
		assertEquals(horas,0);		
	}
	
	@Test
	public void calcularPago1DiaMotoTest() {
		//arrange
		String placa = "bbc15a";
    	RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
		ServicioActualizarHistorial servicioActualizarHistorial = new ServicioActualizarHistorial(repositorioHistorial);
		//act
		Double pago = servicioActualizarHistorial.calcularPago(LocalDateTime.now(), LocalDateTime.now().plusDays(1),placa);
		
		//assert
		assertEquals(pago,4000,0.001);		
	}
	
	@Test
	public void calcularPago1DiaAutoTest() {
		//arrange
		String placa = "bbc155";
    	RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
		ServicioActualizarHistorial servicioActualizarHistorial = new ServicioActualizarHistorial(repositorioHistorial);
		//act
		Double pago = servicioActualizarHistorial.calcularPago(LocalDateTime.now(), LocalDateTime.now().plusDays(1),placa);
		
		//assert
		assertEquals(pago,8000,0.001);		
	}
	
	@Test
	public void calcularPago1DiaMotoConCilindraje600Test() {
		//arrange
		String placa = "bbc15a";
    	RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
    	Mockito.when(repositorioHistorial.devuelveCilindraje(placa)).thenReturn(600);
		ServicioActualizarHistorial servicioActualizarHistorial = new ServicioActualizarHistorial(repositorioHistorial);
		//act
		Double pago = servicioActualizarHistorial.calcularPago(LocalDateTime.now(), LocalDateTime.now().plusDays(1),placa);
		
		//assert
		assertEquals(pago,6000,0.001);		
	}
	
	@Test
	public void calcularPago1Dia3horasAutoTest() {
		//arrange
		String placa = "bbc151";
    	RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
    	Mockito.when(repositorioHistorial.devuelveCilindraje(placa)).thenReturn(600);
		ServicioActualizarHistorial servicioActualizarHistorial = new ServicioActualizarHistorial(repositorioHistorial);
		//act
		Double pago = servicioActualizarHistorial.calcularPago(LocalDateTime.now(), LocalDateTime.now().plusDays(1).plusHours(3),placa);
		
		//assert
		assertEquals(pago,11000,0.001);		
	}
	
	@Test
	public void calcularPago9horasAutoTest() {
		//arrange
		String placa = "bbc151";
    	RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);    	
		ServicioActualizarHistorial servicioActualizarHistorial = new ServicioActualizarHistorial(repositorioHistorial);
		//act
		Double pago = servicioActualizarHistorial.calcularPago(LocalDateTime.now(), LocalDateTime.now().plusHours(9),placa);
		
		//assert
		assertEquals(pago,8000,0.001);		
	}
	
	@Test
	public void calcularPago8horasAutoTest() {
		//arrange
		String placa = "bbc151";
    	RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
		ServicioActualizarHistorial servicioActualizarHistorial = new ServicioActualizarHistorial(repositorioHistorial);
		//act
		Double pago = servicioActualizarHistorial.calcularPago(LocalDateTime.now(), LocalDateTime.now().plusHours(8),placa);
		
		//assert
		assertEquals(pago,8000,0.001);		
	}
	
	@Test
	public void calcularPago9horasMotoTest() {
		//arrange
		String placa = "bbc15c";
    	RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);    	
		ServicioActualizarHistorial servicioActualizarHistorial = new ServicioActualizarHistorial(repositorioHistorial);
		//act
		Double pago = servicioActualizarHistorial.calcularPago(LocalDateTime.now(), LocalDateTime.now().plusHours(9),placa);
		
		//assert
		assertEquals(pago,4000,0.001);		
	}
	
	@Test
	public void calcularPago8horasMotoTest() {
		//arrange
		String placa = "bbc15c";
    	RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
		ServicioActualizarHistorial servicioActualizarHistorial = new ServicioActualizarHistorial(repositorioHistorial);
		//act
		Double pago = servicioActualizarHistorial.calcularPago(LocalDateTime.now(), LocalDateTime.now().plusHours(8),placa);
		
		//assert
		assertEquals(pago,4000,0.001);		
	}
	
	@Test
	public void calcularPago30DiasAutoTest() {
		//arrange
		String placa = "bbc151";
    	RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
		ServicioActualizarHistorial servicioActualizarHistorial = new ServicioActualizarHistorial(repositorioHistorial);
		//act
		Double pago = servicioActualizarHistorial.calcularPago(LocalDateTime.now(), LocalDateTime.now().plusDays(30),placa);
		
		//assert
		assertEquals(pago,240000,0.001);		
	}
		
	@Test
	public void validarSiEsAutoTest() {
		//arrange
		String placa = "aaa123";		
    	RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);    	
		ServicioActualizarHistorial servicioActualizarHistorial = new ServicioActualizarHistorial(repositorioHistorial);
		//act
		String tipo = servicioActualizarHistorial.devuelveTipoDeVehiculo(placa);
		
		//assert
		assertTrue(tipo.equals("auto"));
	}
}
