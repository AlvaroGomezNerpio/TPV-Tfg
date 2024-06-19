package com.tfg.tfg_tienda_fisica.servicios;

import com.tfg.tfg_tienda_fisica.dtos.CategoriaDTO;

import java.util.List;

public interface ICategoriaServicio {

    public List<CategoriaDTO> obtenerTodo();

    public CategoriaDTO guardar(CategoriaDTO categoria);

    public CategoriaDTO obtenerPorId(long id);

    public void eliminar(long id);

}
