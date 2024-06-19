package com.tfg.tfg_tienda_fisica.repositorios;

import com.tfg.tfg_tienda_fisica.modelos.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {

    List<Pedido> findByEmpleadoId(Long usuarioId);

}
