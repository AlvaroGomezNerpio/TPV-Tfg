package com.tfg.tfg_tienda_fisica.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormaPagoDTO {

    private long id;
    private String tipo;

}
