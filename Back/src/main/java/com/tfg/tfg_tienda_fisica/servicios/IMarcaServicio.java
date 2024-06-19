package com.tfg.tfg_tienda_fisica.servicios;

import com.tfg.tfg_tienda_fisica.dtos.MarcaDTO;

import java.util.List;

public interface IMarcaServicio {

    public List<MarcaDTO> obtenerTodo();

    public MarcaDTO guardar(MarcaDTO marca);

    public MarcaDTO obtenerPorId(long id);

    public void eliminar(long id);

}
