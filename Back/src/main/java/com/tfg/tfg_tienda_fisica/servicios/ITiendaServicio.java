package com.tfg.tfg_tienda_fisica.servicios;

import com.tfg.tfg_tienda_fisica.dtos.TiendaDTO;

import java.util.List;

public interface ITiendaServicio {

    public List<TiendaDTO> obtenerTodo();

    public TiendaDTO guardar(TiendaDTO tienda);

    public TiendaDTO obtenerPorId(long id);

    public void eliminar(long id);

}
