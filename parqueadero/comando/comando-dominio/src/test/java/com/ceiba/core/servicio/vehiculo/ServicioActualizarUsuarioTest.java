package com.ceiba.core.servicio.vehiculo;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.core.BasePrueba;
import com.ceiba.core.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.core.modelo.vehiculo.Vehiculo;
import com.ceiba.core.repositorio.RepositorioVehiculo;
import com.ceiba.core.servicio.testdatabuilder.VehiculoTestDataBuilder;
import com.ceiba.core.servicio.vehiculo.ServicioActualizarVehiculo;

public class ServicioActualizarUsuarioTest {
	
	@Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
    	Vehiculo vehiculo = new VehiculoTestDataBuilder().conPlaca("abc123").build();
    	RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
    	Mockito.when(repositorioVehiculo.existeExcluyendoPlaca(Mockito.anyString(),Mockito.anyString())).thenReturn(true);
    	ServicioActualizarVehiculo servicioActualizarVehiculo = new ServicioActualizarVehiculo(repositorioVehiculo);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarVehiculo.ejecutar(vehiculo), ExcepcionDuplicidad.class,"El vehiculo ya existe en el sistema");
    }
}
