package com.tfg.tfg_tienda_fisica.servicios;

import com.tfg.tfg_tienda_fisica.dtos.EjemplarDTO;

import java.util.List;

public interface IEjemplarServicio {

    public List<EjemplarDTO> obtenerTodo();

    public EjemplarDTO guardar(EjemplarDTO ejemplar);

    public EjemplarDTO obtenerPorId(long id);

    public void eliminar(long id);

}
