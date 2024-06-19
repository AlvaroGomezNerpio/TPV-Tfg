package com.tfg.tfg_tienda_fisica.servicios;

import com.tfg.tfg_tienda_fisica.dtos.EmpleadoDTO;

import java.util.List;

public interface IEmpleadoServicio {

    public List<EmpleadoDTO> obtenerTodo();

    public EmpleadoDTO guardar(EmpleadoDTO empleado);

    public EmpleadoDTO obtenerPorId(long id);

    public void eliminar(long id);

}
