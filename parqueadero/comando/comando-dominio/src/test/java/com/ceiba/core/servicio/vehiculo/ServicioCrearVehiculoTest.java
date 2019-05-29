package com.ceiba.core.servicio.vehiculo;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.core.BasePrueba;
import com.ceiba.core.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.core.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.core.modelo.vehiculo.Vehiculo;
import com.ceiba.core.repositorio.RepositorioVehiculo;
import com.ceiba.core.servicio.testdatabuilder.VehiculoTestDataBuilder;
import com.ceiba.core.servicio.vehiculo.ServicioCrearVehiculo;

public class ServicioCrearVehiculoTest {

	@Test
    public void validarPlacaLongitud6Test() {
        // arrange
    	VehiculoTestDataBuilder usuarioTestDataBuilder = new VehiculoTestDataBuilder().conPlaca("abc1111");
        // act - assert
        BasePrueba.assertThrows(() -> usuarioTestDataBuilder.build(), ExcepcionLongitudValor.class, "La placa debe tener una longitud igual a 6");
    }
	
	@Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
    	Vehiculo vehiculo = new VehiculoTestDataBuilder().build();
    	RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
    	Mockito.when(repositorioVehiculo.existe(Mockito.anyString())).thenReturn(true);
    	ServicioCrearVehiculo servicioCrearUsuario = new ServicioCrearVehiculo(repositorioVehiculo);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearUsuario.ejecutar(vehiculo), ExcepcionDuplicidad.class,"El vehiculo ya existe en el sistema");
    }
}
