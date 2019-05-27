package com.ceiba.core.manejador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.core.dao.DaoUsuario;
import com.ceiba.core.modelo.DtoUsuario;

@Component
public class ManejadorListarUsuarios {

    @Autowired
	private final DaoUsuario daoUsuario;

    public ManejadorListarUsuarios(DaoUsuario daoUsuario){
        this.daoUsuario = daoUsuario;
    }

    public List<DtoUsuario> ejecutar(){
        return this.daoUsuario.listar();
    }
}
