package com.tfg.tfg_tienda_fisica.repositorios;

import com.tfg.tfg_tienda_fisica.modelos.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiendaRepositorio  extends JpaRepository<Tienda, Long> {
}
