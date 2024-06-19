package com.tfg.tfg_tienda_fisica.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineaPedidoDTO {

    private long id;
    private double precio;
    private double iva;
    private int unidades;
    private ProductoDTOL producto;
    private FacturaDTOL factura;
    private PedidoDTOL pedido;

}
