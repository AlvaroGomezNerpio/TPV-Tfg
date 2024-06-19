package com.tfg.tfg_tienda_fisica.controladores;

import com.tfg.tfg_tienda_fisica.dtos.EmpleadoDTO;
import com.tfg.tfg_tienda_fisica.servicios.EmpleadoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/empleado")
@CrossOrigin(origins = "*")
public class EmpleadoControlador {

    @Autowired
    EmpleadoServicioImpl empleadoServicio;

    @GetMapping("/listar")
    public List<EmpleadoDTO> obtenerEmpleados(){
        return empleadoServicio.obtenerTodo();
    }

    @PostMapping("/guardar")
    public ResponseEntity<EmpleadoDTO> guardarEmpleado(@RequestBody EmpleadoDTO empleado){

        empleado.setPassword(new BCryptPasswordEncoder(8).encode(empleado.getPassword()));

        empleadoServicio.guardar(empleado);
        return new ResponseEntity<>(empleado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> obtenerEmpleado(@PathVariable long id){
        EmpleadoDTO empleadoId = empleadoServicio.obtenerPorId(id);
        return ResponseEntity.ok(empleadoId);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> actualizarEmpleadoParcial(@PathVariable long id, @RequestBody EmpleadoDTO empleado){

        EmpleadoDTO empleadoId = empleadoServicio.obtenerPorId(id);

        if(empleado.getNombre() != null) {
            empleadoId.setNombre(empleado.getNombre());
        }
        if(empleado.getPassword() != null) {
            empleadoId.setPassword(new BCryptPasswordEncoder(8).encode(empleado.getPassword()));
        }
        if(empleado.getEmail() != null) {
            empleadoId.setEmail(empleado.getEmail());
        }
        if(empleado.getTelefono() != null) {
            empleadoId.setTelefono(empleado.getTelefono());
        }

        EmpleadoDTO empleadoActualizado = empleadoServicio.guardar(empleadoId);
        return new ResponseEntity<>(empleadoActualizado, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarEmpleado(@PathVariable long id){
        this.empleadoServicio.eliminar(id);

        HashMap<String, Boolean> estadoEmpleadoEliminado = new HashMap<>();
        estadoEmpleadoEliminado.put("eliminado", true);
        return  ResponseEntity.ok(estadoEmpleadoEliminado);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<EmpleadoDTO> obtenerEmpleadoByEmail(@PathVariable String email){
        EmpleadoDTO clienteId = empleadoServicio.findByEmail(email);
        clienteId.setPassword(null);
        return ResponseEntity.ok(clienteId);
    }

}
