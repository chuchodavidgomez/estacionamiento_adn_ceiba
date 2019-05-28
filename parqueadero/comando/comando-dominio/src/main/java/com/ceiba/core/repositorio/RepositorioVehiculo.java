package com.ceiba.core.repositorio;

import com.ceiba.core.modelo.usuario.Vehiculo;

public interface RepositorioVehiculo {
	/**
	 * Permite crear un usuario
	 * @param vehiculo
	 * @return el id generado
	 */
    void crear(Vehiculo vehiculo);
    
    /**
	 * Permite actualizar un usuario
	 * @param usuario
	 */
    void actualizar(Vehiculo vehiculo);
    
    /**
     * Permite eliminar un usuario
     * @param id
     */
    void eliminar(String placa);
    
    /**
     * Permite validar si existe un usuario con un nombre
     * @param nombre
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
