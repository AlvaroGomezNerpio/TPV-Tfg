package com.tfg.tfg_tienda_fisica.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDTO{

    private long id;
    private String observaciones;
    private LocalDate fecha;
    private EmpleadoDTOL empleado;

}
