package com.tfg.tfg_tienda_fisica.servicios;

import com.tfg.tfg_tienda_fisica.dtos.FacturaDTO;
import com.tfg.tfg_tienda_fisica.modelos.Factura;
import com.tfg.tfg_tienda_fisica.repositorios.FacturaRepositorio;
import com.tfg.tfg_tienda_fisica.utils.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaServicioImpl implements IFacturaServicio{

    @Autowired
    FacturaRepositorio facturaRepositorio;

    @Override
    public List<FacturaDTO> obtenerTodo() {

        List<Factura> facturas = facturaRepositorio.findAll();
        List<FacturaDTO> facturasDTO = new ArrayList<>();
        if (!facturas.isEmpty()) {

            facturasDTO = ModelMapperUtil.transformDtoList(facturas, FacturaDTO.class);
        }

        return facturasDTO;
    }

    public List<FacturaDTO> findByEmpleadoId(Long usuarioId){
        List<Factura> facturas = facturaRepositorio.findByEmpleadoId(usuarioId);
        List<FacturaDTO> facturasDTO = new ArrayList<>();
        if (!facturas.isEmpty()) {

            facturasDTO = ModelMapperUtil.transformDtoList(facturas, FacturaDTO.class);
        }

        return facturasDTO;
    }


    @Override
    public FacturaDTO guardar(FacturaDTO factura) {

        Factura facturaEnti = ModelMapperUtil.transformDto(factura, Factura.class);

        return ModelMapperUtil.transformDto(facturaRepositorio.save(facturaEnti), FacturaDTO.class);

    }

    @Override
    public FacturaDTO obtenerPorId(long id) {

        Optional<Factura> factura = facturaRepositorio.findById(id);
        FacturaDTO facturaDTO = new FacturaDTO();

        if (factura.isPresent()) {

            facturaDTO = ModelMapperUtil.transformDto(factura.get(), FacturaDTO.class);

            return facturaDTO;
        } else {

            return null;
        }

    }

    @Override
    public void eliminar(long id) {
        facturaRepositorio.deleteById(id);
    }
}
