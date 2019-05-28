package com.ceiba.core.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.core.manejador.ManejadorListarVehiculos;
import com.ceiba.core.modelo.DtoVehiculo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/vehiculos") 
@Api(tags={"Controlador consulta vehiculos"}) 
public class ConsultaControladorVehiculo {

	private final ManejadorListarVehiculos manejadorListarVehiculos;

	public ConsultaControladorVehiculo(ManejadorListarVehiculos manejadorListarVehiculos) {
		this.manejadorListarVehiculos = manejadorListarVehiculos;
	}

	@GetMapping
	@ApiOperation("Listar Usuarios")
	public List<DtoVehiculo> listar() {
		return this.manejadorListarVehiculos.ejecutar();
	}

}
