package com.tfg.tfg_tienda_fisica.repositorios;

import com.tfg.tfg_tienda_fisica.modelos.LineaPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineaPedidoRepositorio extends JpaRepository<LineaPedido, Long> {

    List<LineaPedido> findByPedidoId(Long pedidoId);

    List<LineaPedido> findByFacturaId(Long facturaId);

    List<LineaPedido> findByProductoId(Long productoId);

}
