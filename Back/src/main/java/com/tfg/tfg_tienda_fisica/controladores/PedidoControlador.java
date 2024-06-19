package com.tfg.tfg_tienda_fisica.controladores;

import com.tfg.tfg_tienda_fisica.dtos.PedidoDTO;
import com.tfg.tfg_tienda_fisica.servicios.PedidoServicioImpl;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins = "*")
public class PedidoControlador {

    @Autowired
    PedidoServicioImpl pedidoServicio;

    @GetMapping("/listar")
    public List<PedidoDTO> obtenerPedidos(){
        return pedidoServicio.obtenerTodo();
    }

    @GetMapping("/empleado/listar")
    public List<PedidoDTO> obtenerPedidosEmpleados(){

        List<PedidoDTO> pedidos = pedidoServicio.obtenerTodo();
        List<PedidoDTO> pedidosEmpleados = new ArrayList<>();

        for (PedidoDTO pedido : pedidos){

            if (pedido.getEmpleado() != null){
                pedidosEmpleados.add(pedido);
            }

        }

        return pedidosEmpleados;

    }

//    @GetMapping("/empleado/{empleadoId}")
//    public List<PedidoDTO> obtenerPedidosByUsuario(Long empleadoId){
//        return pedidoServicio.findByEmpleadoId(empleadoId);
//    }

    @GetMapping("/empleado/end/{empleadoId}")
    public PedidoDTO obtenerEndFacturaByUsuario(@PathVariable Long empleadoId){
        List<PedidoDTO> pedidosUsusario = pedidoServicio.findByEmpleadoId(empleadoId);

        int indice = pedidosUsusario.size() -1;

        System.out.println(indice);

        PedidoDTO pedido =  pedidosUsusario.get(indice);

        return pedido;
    }

    @PostMapping("/guardar")
    public ResponseEntity<PedidoDTO> guardarPedido(@RequestBody PedidoDTO pedido){

        LocalDate fechaActual = LocalDate.now();

        pedido.setFecha(fechaActual);

        fechaActual = fechaActual.plusDays(3);

        pedido.setFechaEntrega(fechaActual);
        pedidoServicio.guardar(pedido);
        return new ResponseEntity<>(pedido, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> obtenerPedido(@PathVariable long id){
        PedidoDTO pedidoId = pedidoServicio.obtenerPorId(id);
        return ResponseEntity.ok(pedidoId);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PedidoDTO> actualizarPedidoParcial(@PathVariable long id, @RequestBody PedidoDTO pedido){

        PedidoDTO pedidoId = pedidoServicio.obtenerPorId(id);

        if (pedido.getEstado() != null){
            pedidoId.setEstado(pedido.getEstado());
        }

        PedidoDTO pedidoActualizado = pedidoServicio.guardar(pedidoId);
        return new ResponseEntity<>(pedidoActualizado, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarPedido(@PathVariable long id){
        this.pedidoServicio.eliminar(id);

        HashMap<String, Boolean> estadoPedidoEliminado = new HashMap<>();
        estadoPedidoEliminado.put("eliminado", true);
        return  ResponseEntity.ok(estadoPedidoEliminado);
    }

}
