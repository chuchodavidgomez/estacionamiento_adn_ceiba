package com.ceiba.core.servicio.vehiculo;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.core.BasePrueba;
import com.ceiba.core.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.core.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.core.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.core.modelo.vehiculo.Vehiculo;
import com.ceiba.core.repositorio.RepositorioVehiculo;
import com.ceiba.core.servicio.testdatabuilder.VehiculoTestDataBuilder;
import com.ceiba.core.servicio.vehiculo.ServicioCrearVehiculo;

public class ServicioCrearVehiculoTest {

	@Test
    public void validarIngresarPlaca() {
        // arrange
    	VehiculoTestDataBuilder VehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(null);
        // act - assert
        BasePrueba.assertThrows(() -> VehiculoTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar la placa");
    }
	
	@Test
    public void validarPlacaLongitud6Test() {
        // arrange
    	VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca("abc1111");
        // act - assert
        BasePrueba.assertThrows(() -> vehiculoTestDataBuilder.build(), ExcepcionLongitudValor.class, "La placa debe tener una longitud igual a 6");
    }
	
	@Test
    public void validarIngresarTipo() {
        // arrange
    	VehiculoTestDataBuilder VehiculoTestDataBuilder = new VehiculoTestDataBuilder().conTipo(null);
        // act - assert
        BasePrueba.assertThrows(() -> VehiculoTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar el tipo");
    }
	
	@Test
    public void validarIngresarMarca() {
        // arrange
    	VehiculoTestDataBuilder VehiculoTestDataBuilder = new VehiculoTestDataBuilder().conMarca(null);
        // act - assert
        BasePrueba.assertThrows(() -> VehiculoTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar la marca");
    }
	
	@Test
    public void validarIngresarModelo() {
        // arrange
    	VehiculoTestDataBuilder VehiculoTestDataBuilder = new VehiculoTestDataBuilder().conModelo(null);
        // act - assert
        BasePrueba.assertThrows(() -> VehiculoTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar el modelo");
    }
	
	@Test
    public void validarVehiculoExistenciaPreviaTest() {
        // arrange
    	Vehiculo vehiculo = new VehiculoTestDataBuilder().build();
    	RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
    	Mockito.when(repositorioVehiculo.existe(Mockito.anyString())).thenReturn(true);
    	ServicioCrearVehiculo servicioCrearVehiculo = new ServicioCrearVehiculo(repositorioVehiculo);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearVehiculo.ejecutar(vehiculo), ExcepcionDuplicidad.class,"El vehiculo ya existe en el sistema");
    }
	/*
	@Test
    public void validarVehiculoExistenciaPreviaTest2() {
        // arrange
    	Vehiculo vehiculo = new VehiculoTestDataBuilder().build();
    	RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
    	Mockito.when(repositorioVehiculo.existe(Mockito.anyString())).thenReturn(false);
    	ServicioCrearVehiculo servicioCrearVehiculo = new ServicioCrearVehiculo(repositorioVehiculo);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearVehiculo.ejecutar(vehiculo), ExcepcionDuplicidad.class,"El vehiculo ya existe en el sistema");
    }*/
}
