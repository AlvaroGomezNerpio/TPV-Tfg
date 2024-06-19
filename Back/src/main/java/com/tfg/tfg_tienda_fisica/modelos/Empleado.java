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
@Table(name  = "Empleados", catalog = "tfg")
public class Empleado implements Serializable {

    private static final long serialVersionUID = -6475114551058527268L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = true)
    private long Id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Email")
    private String email;
    @Column(name = "Telefono")
    private String telefono;
    @Column(name = "Password")
    private String password;

    @ManyToOne()
    @JoinColumn(name = "Roles_Id")
    private Rol rol;

    @OneToMany(mappedBy = "empleado",cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Factura> facturas;

    @OneToMany(mappedBy = "empleado",cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Pedido> pedidos;



}
