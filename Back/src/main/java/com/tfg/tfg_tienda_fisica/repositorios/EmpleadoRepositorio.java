package com.tfg.tfg_tienda_fisica.repositorios;

import com.tfg.tfg_tienda_fisica.modelos.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {

    Optional<Empleado> findOneByEmail(String email);

    Optional<Empleado> findByEmail(String email);

}
