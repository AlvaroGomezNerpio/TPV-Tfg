package com.tfg.tfg_tienda_fisica.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDTOL {

    private long Id;
    private String nombre;
    private String email;
    private String telefono;
    private String password;
}
