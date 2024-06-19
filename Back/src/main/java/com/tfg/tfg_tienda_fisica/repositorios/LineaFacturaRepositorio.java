package com.tfg.tfg_tienda_fisica.repositorios;

import com.tfg.tfg_tienda_fisica.modelos.LineaFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineaFacturaRepositorio extends JpaRepository<LineaFactura, Long> {

    List<LineaFactura> findByProductoId(Long productoId);

    List<LineaFactura> findByFacturaId(Long facturaId);

}
