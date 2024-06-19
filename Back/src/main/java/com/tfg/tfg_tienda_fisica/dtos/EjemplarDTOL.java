package com.tfg.tfg_tienda_fisica.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EjemplarDTOL {

    private long Id;
    private String serie;
    private Date fechaVenta;
    private Date fechaCompra;
    private String estado;
    private int unidades;

}
