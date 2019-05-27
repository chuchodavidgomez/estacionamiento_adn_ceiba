//package com.ceiba.core.servicio;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import com.ceiba.core.dao.DaoUsuario;
//import com.ceiba.core.dominio.excepcion.ExcepcionSinDatos;
//import com.ceiba.core.modelo.DtoUsuario;
//
//@Component
//public class ServicioConsultarUsuarioSpringSecurity implements UserDetailsService {
//
//    private DaoUsuario daoUsuario;
//
//    @Autowired
//    public ServicioConsultarUsuarioSpringSecurity(DaoUsuario daoUsuario) {
//        this.daoUsuario = daoUsuario;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String usuario) {
//        BCryptPasswordEncoder codificarClave = new BCryptPasswordEncoder();
//
//        DtoUsuario dtoUsuario = daoUsuario.consultar(usuario);
//        if(dtoUsuario == null) {
//            throw new ExcepcionSinDatos("El usuario " + usuario + " no existe");
//        }
//
//        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ADMINISTRADOR"));
//        return new User(dtoUsuario.getNombreUsuario(), codificarClave.encode(dtoUsuario.getClave()), authorities);
//    }
//}
