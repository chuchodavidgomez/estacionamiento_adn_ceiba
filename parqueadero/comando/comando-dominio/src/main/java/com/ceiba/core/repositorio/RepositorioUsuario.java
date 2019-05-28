package com.ceiba.core.repositorio;

import com.ceiba.core.modelo.usuario.Vehiculo;

public interface RepositorioUsuario {
	/**
	 * Permite crear un usuario
	 * @param usuario
	 * @return el id generado
	 */
    Long crear(Vehiculo usuario);
    
    /**
	 * Permite actualizar un usuario
	 * @param usuario
	 */
    void actualizar(Vehiculo usuario);
    
    /**
     * Permite eliminar un usuario
     * @param id
     */
    void eliminar(Long id);
    
    /**
     * Permite validar si existe un usuario con un nombre
     * @param nombre
     * @return si existe o no
     */
    boolean existe(String nombre);
    
    /**
     * Permite validar si existe un usuario con un nombre excluyendo un id
     * @param nombre
     * @return si existe o no
     */
    boolean existeExcluyendoId(String id,String nombre);

}
