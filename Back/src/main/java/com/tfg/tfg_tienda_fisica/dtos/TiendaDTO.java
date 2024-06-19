package com.tfg.tfg_tienda_fisica.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TiendaDTO{

    private long id;
    private String nombre;
    private String ubicacion;
    private String ciudad;
    private String pais;

}
