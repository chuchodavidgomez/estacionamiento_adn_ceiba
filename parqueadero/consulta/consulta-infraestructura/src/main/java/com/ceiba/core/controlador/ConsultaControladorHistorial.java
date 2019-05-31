package com.ceiba.core.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.core.manejador.ManejadorListarHistorial;
import com.ceiba.core.modelo.DtoHistorial;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/historial")
@Api(tags= {"Controlador consulta historial"})
public class ConsultaControladorHistorial {

	private final ManejadorListarHistorial manejadorListarHistorial;
	
	public ConsultaControladorHistorial(ManejadorListarHistorial manejadorListarHistorial) {
		this.manejadorListarHistorial = manejadorListarHistorial;
	}
	
	@GetMapping
	@ApiOperation("Listar Historial")
	public List<DtoHistorial> listar(){
		return this.manejadorListarHistorial.ejecutar();
	}
}
