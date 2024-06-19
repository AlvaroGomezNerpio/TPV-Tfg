package com.tfg.tfg_tienda_fisica.repositorios;

import com.tfg.tfg_tienda_fisica.modelos.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepositorio extends JpaRepository<Factura, Long> {

    List<Factura> findByEmpleadoId(Long empleadoId);

}
