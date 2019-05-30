package com.ceiba.core.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.core.comando.ComandoVehiculo;
import com.ceiba.core.manejador.ManejadorActualizarVehiculo;
import com.ceiba.core.manejador.ManejadorCrearVehiculo;
import com.ceiba.core.manejador.ManejadorEliminarVehiculo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/vehiculos")
@Api(tags = { "Controlador comando vehiculo"})
public class ComandoControladorVehiculo {

	private final ManejadorCrearVehiculo manejadorCrearVehiculo;
	private final ManejadorEliminarVehiculo manejadorEliminarVehiculo;
	private final ManejadorActualizarVehiculo manejadorActualizarVehiculo;

	@Autowired
	public ComandoControladorVehiculo(ManejadorCrearVehiculo manejadorCrearVehiculo,
			ManejadorEliminarVehiculo manejadorEliminarVehiculo,ManejadorActualizarVehiculo manejadorActualizarVehiculo) {
		this.manejadorCrearVehiculo = manejadorCrearVehiculo;
		this.manejadorEliminarVehiculo = manejadorEliminarVehiculo;
		this.manejadorActualizarVehiculo = manejadorActualizarVehiculo;
	}

	@PostMapping("/ingresar")
	@ApiOperation("Crear vehiculo")
	public void crear(@RequestBody ComandoVehiculo comandoVehiculo) {
		manejadorCrearVehiculo.ejecutar(comandoVehiculo);
	}

	@DeleteMapping(value="/{placa}")
	@ApiOperation("Eliminar vehiculo")
	public void eliminar(@PathVariable String placa) {
		manejadorEliminarVehiculo.ejecutar(placa);
	}
	
	@PutMapping(value="/{placa}")
	@ApiOperation("Actualizar vehiculo")
	public void actualizar(@RequestBody ComandoVehiculo comandoVehiculo,@PathVariable String placa) {
		comandoVehiculo.setPlaca(placa);
		manejadorActualizarVehiculo.ejecutar(comandoVehiculo);
	}
}
