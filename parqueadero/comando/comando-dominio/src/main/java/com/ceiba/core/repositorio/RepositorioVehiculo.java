package com.ceiba.core.repositorio;

import com.ceiba.core.modelo.vehiculo.Vehiculo;

public interface RepositorioVehiculo {
	/**
	 * Permite crear un vehiculo
	 * @param vehiculo
	 */
    void crearVehiculo(Vehiculo vehiculo);
    
    /**
	 * Permite actualizar un vehiculo
	 * @param vehiculo
	 */
    void actualizarVehiculo(Vehiculo vehiculo, String placaKey);
    
    /**
     * Permite eliminar un vehiculo
     * @param placa
     */
    void eliminarVehiculo(String placa);
    
    /**
     * Permite validar si existe un vehiculo con esa placa
     * @param placa
     * @return si existe o no
     */
    boolean existeVehiculo(String placa);
}
