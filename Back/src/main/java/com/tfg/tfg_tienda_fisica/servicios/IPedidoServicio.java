package com.tfg.tfg_tienda_fisica.servicios;

import com.tfg.tfg_tienda_fisica.dtos.PedidoDTO;

import java.util.List;

public interface IPedidoServicio {

    public List<PedidoDTO> obtenerTodo();

    public PedidoDTO guardar(PedidoDTO pedido);

    public PedidoDTO obtenerPorId(long id);

    public void eliminar(long id);

}
