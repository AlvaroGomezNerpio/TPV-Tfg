package com.tfg.tfg_tienda_fisica.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name  = "Roles", catalog = "tfg")
public class Rol implements Serializable {

    private static final long serialVersionUID = 8501967884297483471L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = true)
    private long id;
    @Column(name = "Rol")
    private String rol;
    @OneToMany(mappedBy = "rol",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Empleado> empleados;

}
