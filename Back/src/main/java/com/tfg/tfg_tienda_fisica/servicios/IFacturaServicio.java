package com.tfg.tfg_tienda_fisica.servicios;

import com.tfg.tfg_tienda_fisica.dtos.FacturaDTO;

import java.util.List;

public interface IFacturaServicio {

    public List<FacturaDTO> obtenerTodo();

    public FacturaDTO guardar(FacturaDTO factura);

    public FacturaDTO obtenerPorId(long id);

    public void eliminar(long id);

}
