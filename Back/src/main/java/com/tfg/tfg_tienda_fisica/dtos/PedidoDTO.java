package com.tfg.tfg_tienda_fisica.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private long Id;
    private LocalDate fechaEntrega;
    private LocalDate fecha;
    private String estado;
    private FormaPagoDTO formaPago;
    private EmpleadoDTO empleado;

}
