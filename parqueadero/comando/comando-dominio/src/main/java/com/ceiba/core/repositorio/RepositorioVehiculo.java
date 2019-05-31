package com.ceiba.core.repositorio;

import com.ceiba.core.modelo.vehiculo.Vehiculo;

public interface RepositorioVehiculo {
	/**
	 * Permite crear un vehiculo
	 * @param vehiculo
	 */
    void crear(Vehiculo vehiculo);
    
    /**
	 * Permite actualizar un vehiculo
	 * @param vehiculo
	 */
    void actualizar(Vehiculo vehiculo);
    
    /**
     * Permite eliminar un vehiculo
     * @param placa
     */
    void eliminar(String placa);
    
    /**
     * Permite validar si existe un vehiculo con esa placa
     * @param placa
     * @return si existe o no
     */
    boolean existe(String placa);
    
    /**
     * Permite validar si existe un usuario con un nombre excluyendo un id
     * @param nombre
     * @return si existe o no
     */
    boolean existeExcluyendoPlaca(String placa,String marca);

}
