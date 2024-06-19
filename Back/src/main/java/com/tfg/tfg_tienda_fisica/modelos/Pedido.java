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
@Table(name  = "Pedidos", catalog = "tfg")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 3508480517121411311L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = true)
    private long Id;
    @Column(name = "Fechaentrega")
    private LocalDate fechaEntrega;
    @Column(name = "Estado")
    private String estado;

    @Column(name = "Fecha")
    private LocalDate fecha;

    @ManyToOne()
    @JoinColumn(name = "Formaspagos_Id")
    private FormaPago formaPago;

    @ManyToOne()
    @JoinColumn(name = "Empleados_Id")
    private Empleado empleado;

    @OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL, orphanRemoval = false)
    private List<LineaPedido> lineaPedidos;

}
