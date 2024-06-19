package com.tfg.tfg_tienda_fisica.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name  = "Facturas", catalog = "tfg")
public class Factura implements Serializable {

    private static final long serialVersionUID = 8603669890300815232L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = true)
    private long id;
    @Column(name = "Observaciones")
    private String observaciones;
    @Column(name = "Fecha")
    private LocalDate fecha;

    @ManyToOne()
    @JoinColumn(name = "Empleados_Id")
    private Empleado empleado;

    @OneToMany(mappedBy = "factura",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineaFactura> lineaFacturas;

}
