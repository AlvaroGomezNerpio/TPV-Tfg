package com.tfg.tfg_tienda_fisica.servicios;

import com.tfg.tfg_tienda_fisica.dtos.ProductoDTO;

import java.util.List;

public interface IProductoServicio {

    public List<ProductoDTO> obtenerTodo();

    public ProductoDTO guardar(ProductoDTO producto);

    public ProductoDTO obtenerPorId(long id);

    public void eliminar(long id);

}
