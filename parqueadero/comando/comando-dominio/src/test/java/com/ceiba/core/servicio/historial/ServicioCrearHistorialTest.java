package com.ceiba.core.servicio.historial;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.core.BasePrueba;
import com.ceiba.core.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.core.dominio.excepcion.ExcepcionDuplicidad;
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
    public void validarIngresarFechaIngreso() {
        // arrange
    	HistorialTestDataBuilder HistorialTestDataBuilder = new HistorialTestDataBuilder().conFechaIngreso(null);
        // act - assert
        BasePrueba.assertThrows(() -> HistorialTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de ingreso");
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
}