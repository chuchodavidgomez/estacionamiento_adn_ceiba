package com.ceiba.core.controlador;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.core.aplicacion.ComandoRespuesta;
import com.ceiba.core.comando.ComandoHistorial;
import com.ceiba.core.manejador.ManejadorActualizarHistorial;
import com.ceiba.core.manejador.ManejadorCrearHistorial;
import com.ceiba.core.manejador.ManejadorEliminarHistorial;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/historial")
public class ComandoControladorHistorial {
	
	private final ManejadorActualizarHistorial manejadorActualizarHistorial;
	private final ManejadorEliminarHistorial manejadorEliminarHistorial;
	private final ManejadorCrearHistorial manejadorCrearHistorial;
	
	public ComandoControladorHistorial(ManejadorCrearHistorial manejadorCrearHistorial, ManejadorEliminarHistorial manejadorEliminarHistorial, ManejadorActualizarHistorial manejadorActualizarHistorial) {
		this.manejadorActualizarHistorial = manejadorActualizarHistorial;
		this.manejadorCrearHistorial = manejadorCrearHistorial;
		this.manejadorEliminarHistorial = manejadorEliminarHistorial;
	}
	
	@PostMapping("/ingresar")
	@ApiOperation("Ingresar nuevo elemento al historial")
	public ComandoRespuesta<Long> crear(@RequestBody ComandoHistorial comandoHistorial){
		return manejadorCrearHistorial.ejecutar(comandoHistorial);
	}
	
	@DeleteMapping(value="/eliminar/{id}")
	@ApiOperation("Eliminar registro")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarHistorial.ejecutar(id);
	}
	
	@PutMapping(value="/actualizar/{id}")
	@ApiOperation("Actualizar historial")
	public ComandoRespuesta<Double> actualizar(@RequestBody ComandoHistorial comandoHistorial, @PathVariable Long id) {
		comandoHistorial.setId(id);
		return manejadorActualizarHistorial.ejecutar(comandoHistorial);
	}
	

}
