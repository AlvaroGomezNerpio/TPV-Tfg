package com.tfg.tfg_tienda_fisica.servicios;

import com.tfg.tfg_tienda_fisica.dtos.PedidoDTO;
import com.tfg.tfg_tienda_fisica.modelos.Pedido;
import com.tfg.tfg_tienda_fisica.repositorios.PedidoRepositorio;
import com.tfg.tfg_tienda_fisica.utils.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServicioImpl implements  IPedidoServicio{

    @Autowired
    PedidoRepositorio pedidoRepositorio;

    @Override
    public List<PedidoDTO> obtenerTodo() {

        List<Pedido> pedidos = pedidoRepositorio.findAll();
        List<PedidoDTO> pedidosDTO = new ArrayList<>();
        if (!pedidos.isEmpty()) {

            pedidosDTO = ModelMapperUtil.transformDtoList(pedidos, PedidoDTO.class);
        }

        return pedidosDTO;

    }

    @Override
    public PedidoDTO guardar(PedidoDTO pedido) {

        Pedido pedidoEnti = ModelMapperUtil.transformDto(pedido, Pedido.class);

        return ModelMapperUtil.transformDto(pedidoRepositorio.save(pedidoEnti), PedidoDTO.class);

    }

    @Override
    public PedidoDTO obtenerPorId(long id) {

        Optional<Pedido> pedido = pedidoRepositorio.findById(id);
        PedidoDTO pedidoDTO = new PedidoDTO();

        if (pedido.isPresent()) {

            pedidoDTO = ModelMapperUtil.transformDto(pedido.get(), PedidoDTO.class);

            return pedidoDTO;
        } else {

            return null;
        }

    }

    public List<PedidoDTO> findByEmpleadoId(Long empleadoId){
        List<Pedido> pedidos = pedidoRepositorio.findByEmpleadoId(empleadoId);
        List<PedidoDTO> pedidosDTO = new ArrayList<>();
        if (!pedidos.isEmpty()) {

            pedidosDTO = ModelMapperUtil.transformDtoList(pedidos, PedidoDTO.class);
        }

        return pedidosDTO;
    }


    @Override
    public void eliminar(long id) {
        pedidoRepositorio.deleteById(id);
    }
}
