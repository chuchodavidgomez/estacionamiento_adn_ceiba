package com.ceiba.core.servicio.vehiculo;

import com.ceiba.core.repositorio.RepositorioVehiculo;

public class ServicioEliminarVehiculo {

    private final RepositorioVehiculo repositorioVehiculo;

    public ServicioEliminarVehiculo(RepositorioVehiculo repositorioVehiculo) {
        this.repositorioVehiculo = repositorioVehiculo;
    }

    public void ejecutar(String placa) {
        this.repositorioVehiculo.eliminarVehiculo(placa);
    }
}
