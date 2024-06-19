package com.tfg.tfg_tienda_fisica.security;

import com.tfg.tfg_tienda_fisica.modelos.Empleado;
import com.tfg.tfg_tienda_fisica.repositorios.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Empleado empleado =  empleadoRepositorio.findOneByEmail(email).orElseThrow(() -> new UsernameNotFoundException("El usuario con el email "+email+" no exoste"));

        return new UserDetailsImpl(empleado);

    }
}
