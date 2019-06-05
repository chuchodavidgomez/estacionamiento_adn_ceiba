package com.ceiba.core.repositorio;

import com.ceiba.core.modelo.historial.Historial;

public interface RepositorioHistorial {
	/**
	 * Permite crear un historial nuevo
	 * @param historial
	 * @return el id del historial
	 */
    Long crear(Historial historial);
    
    /**
	 * Permite actualizar un historial
	 * @param historial
	 */
    Double actualizar(Historial historial);
    
    /**
     * Permite eliminar un historial
     * @param id
     */
    void eliminar(long id);
        
    /**
     * Permite validar si un vehiculo se encuentra parquedo
     * @param nombre
     * @return si existe o no
     */
    boolean estaParqueado(String placaVehiculo);

    /**
     * Permite validar si existe un historial con ese id
     * @param id
     * @return si existe o no
     */
	boolean existe(Long id);
	
	/**
     * devuelve la cantidad de vehiculos dependiendo del tipo
     * @param tipo
     * @return cantidad del vehiculo solicitado
     */
	int cantidadVehiculos(String tipo);
	
	/**
     * devuelve el tipo del vehiculo
     * @param placa
     * @return tipo
     */
	String devuelveTipo(String placa);

	/**
     * devuelve el cilindraje del vehiculo
     * @param placa
     * @return cilindraje
     */
	int devuelveCilindraje(String placa);
}
