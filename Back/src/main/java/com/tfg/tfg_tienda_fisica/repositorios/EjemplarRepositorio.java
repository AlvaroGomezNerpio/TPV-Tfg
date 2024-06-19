package com.tfg.tfg_tienda_fisica.repositorios;

import com.tfg.tfg_tienda_fisica.modelos.Ejemplar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EjemplarRepositorio extends JpaRepository<Ejemplar, Long> {

    List<Ejemplar> findByProductoId(Long productoId);

}
