package com.tfg.tfg_tienda_fisica.servicios;

import com.tfg.tfg_tienda_fisica.dtos.EmpleadoDTO;
import com.tfg.tfg_tienda_fisica.modelos.Empleado;
import com.tfg.tfg_tienda_fisica.repositorios.EmpleadoRepositorio;
import com.tfg.tfg_tienda_fisica.utils.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServicioImpl implements IEmpleadoServicio {

    @Autowired
    EmpleadoRepositorio empleadoRepositorio;

    @Override
    public List<EmpleadoDTO> obtenerTodo() {

        List<Empleado> empleados = empleadoRepositorio.findAll();
        List<EmpleadoDTO> empleadoDTOS = new ArrayList<>();

        if (!empleados.isEmpty()) {

            empleadoDTOS = ModelMapperUtil.transformDtoList(empleados, EmpleadoDTO.class);
        }

        return empleadoDTOS;

    }

    @Override
    public EmpleadoDTO guardar(EmpleadoDTO empleado) {

        Empleado empleadoEnti = ModelMapperUtil.transformDto(empleado, Empleado.class);

        return ModelMapperUtil.transformDto(empleadoRepositorio.save(empleadoEnti), EmpleadoDTO.class);

    }

    @Override
    public EmpleadoDTO obtenerPorId(long id) {

        Optional<Empleado> empleado = empleadoRepositorio.findById(id);
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();

        if (empleado.isPresent()) {

            empleadoDTO = ModelMapperUtil.transformDto(empleado.get(), EmpleadoDTO.class);

            return empleadoDTO;
        } else {

            return null;
        }

    }

    public EmpleadoDTO findByEmail(String email){

        Optional<Empleado> empleado = empleadoRepositorio.findByEmail(email);
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();

        if (empleado.isPresent()) {

            empleadoDTO = ModelMapperUtil.transformDto(empleado.get(), EmpleadoDTO.class);

            return empleadoDTO;
        } else {

            return null;
        }

    }


    @Override
    public void eliminar(long id) {

        empleadoRepositorio.deleteById(id);
    }
}
