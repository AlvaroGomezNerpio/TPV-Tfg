package com.tfg.tfg_tienda_fisica.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineaFacturaDTO{

    private long id;
    private double iva;
    private double precio;
    private int unidades;
    private String serie;
    private ProductoDTOL producto;
    private FacturaDTOL factura;

}
