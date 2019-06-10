package com.ceiba.core.servicio.historial;

import static org.junit.Assert.assertTrue;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.core.BasePrueba;
import com.ceiba.core.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.core.dominio.excepcion.ExcepcionDiaNoHabil;
import com.ceiba.core.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.core.dominio.excepcion.ExcepcionEstaParqueado;
import com.ceiba.core.dominio.excepcion.ExcepcionExcedeCantidad;
import com.ceiba.core.modelo.historial.Historial;
import com.ceiba.core.repositorio.RepositorioHistorial;
import com.ceiba.core.servicio.testdatabuilder.HistorialTestDataBuilder;
import com.ceiba.core.servicio.historial.ServicioCrearHistorial;

public class ServicioCrearHistorialTest {

	@Test
    public void validarIngresarPlacaTest() {
        // arrange
    	HistorialTestDataBuilder HistorialTestDataBuilder = new HistorialTestDataBuilder().conPlacaVehiculo(null);
        // act - assert
        BasePrueba.assertThrows(() -> HistorialTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar la placa");
    }
	
	@Test
    public void validarVehiculoParqueadoTest() {
        // arrange
		Historial Historial = new HistorialTestDataBuilder().build();
    	RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
    	Mockito.when(repositorioHistorial.estaParqueado(Mockito.anyString())).thenReturn(true);
    	ServicioCrearHistorial servicioCrearHistorial = new ServicioCrearHistorial(repositorioHistorial);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearHistorial.ejecutar(Historial), ExcepcionEstaParqueado.class, "El vehiculo ya esta parqueado");
    }
	
	@Test
    public void validarHistorialExistentePrevioTest() {
        // arrange
    	Historial Historial = new HistorialTestDataBuilder().build();
    	RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
    	Mockito.when(repositorioHistorial.existe(Mockito.anyLong())).thenReturn(true);
    	ServicioCrearHistorial servicioCrearHistorial = new ServicioCrearHistorial(repositorioHistorial);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearHistorial.ejecutar(Historial), ExcepcionDuplicidad.class,"El historial ya existe en el sistema");
    }
	

	@Test
    public void validarCuposDisponiblesMotoTest() {
        // arrange
		Historial Historial = new HistorialTestDataBuilder().conPlacaVehiculo("abc12c").build();
    	RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
    	Mockito.when(repositorioHistorial.cantidadVehiculos("moto")).thenReturn(11);
    	ServicioCrearHistorial servicioCrearHistorial = new ServicioCrearHistorial(repositorioHistorial);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearHistorial.ejecutar(Historial), ExcepcionExcedeCantidad.class, "No hay cupos disponibles para moto");
    }
	
	@Test
    public void validarCuposDisponiblesAutoTest() {
        // arrange
		Historial Historial = new HistorialTestDataBuilder().conPlacaVehiculo("abc123").build();
    	RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
    	Mockito.when(repositorioHistorial.cantidadVehiculos("auto")).thenReturn(21);
    	ServicioCrearHistorial servicioCrearHistorial = new ServicioCrearHistorial(repositorioHistorial);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearHistorial.ejecutar(Historial), ExcepcionExcedeCantidad.class, "No hay cupos disponibles para auto");
    }	
	
	@Test
    public void validarDiaNoHabilTest() {
        // arrange
		Historial historial = new HistorialTestDataBuilder().conPlacaVehiculo("abc123").conFechaIngreso(LocalDateTime.of(2019, 6, 2, 5, 30, 45, 0)).build();
    	RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
    	ServicioCrearHistorial servicioCrearHistorial = new ServicioCrearHistorial(repositorioHistorial);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearHistorial.validarPlaca(historial.getPlaca(), historial.getFechaIngreso().getDayOfWeek()), ExcepcionDiaNoHabil.class, "No puede ingresar, dia no habil");
    }
	
	@Test
	public void validarLetraTest() {
		//arrange
		String placa = "aaa123";
    	RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);    	
		ServicioCrearHistorial servicioCrearHistorial = new ServicioCrearHistorial(repositorioHistorial);
		//act
		Boolean esValida = servicioCrearHistorial.validaPrimeraLetra(placa);
		
		//assert
		assertTrue(esValida);
	}
	
	@Test
	public void validarSiEsDomingoTest() {
		//arrange
		DayOfWeek dayOfToday = LocalDateTime.of(2019, 6, 2, 5, 30, 45, 0).getDayOfWeek();		
    	RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
		ServicioCrearHistorial servicioCrearHistorial = new ServicioCrearHistorial(repositorioHistorial);
		//act
		Boolean esValida = servicioCrearHistorial.esLunesODomingo(dayOfToday);
		
		//assert
		assertTrue(esValida);
	}
	
	@Test
	public void validarSiEsAutoTest() {
		//arrange
		String placa = "aaa123";		
    	RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);    	
		ServicioCrearHistorial servicioCrearHistorial = new ServicioCrearHistorial(repositorioHistorial);
		//act
		String tipo = servicioCrearHistorial.devuelveTipoDeVehiculo(placa);
		
		//assert
		assertTrue(tipo.equals("auto"));
	}
}