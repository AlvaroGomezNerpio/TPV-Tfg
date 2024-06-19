package com.tfg.tfg_tienda_fisica.servicios;

import com.tfg.tfg_tienda_fisica.dtos.LineaFacturaDTO;

import java.util.List;

public interface ILineaFacturaServicio {

    public List<LineaFacturaDTO> obtenerTodo();

    public LineaFacturaDTO guardar(LineaFacturaDTO lineaFactura);

    public LineaFacturaDTO obtenerPorId(long id);

    public void eliminar(long id);

}
