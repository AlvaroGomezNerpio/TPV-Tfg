package com.tfg.tfg_tienda_fisica.servicios;


import com.tfg.tfg_tienda_fisica.dtos.RolDTO;

import java.util.List;

public interface IRolServicio {

    public List<RolDTO> obtenerTodo();

    public RolDTO guardar(RolDTO rol);

    public RolDTO obtenerPorId(long id);

    public void eliminar(long id);

}
