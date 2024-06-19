package com.tfg.tfg_tienda_fisica.servicios;

import com.tfg.tfg_tienda_fisica.dtos.ProductoDTO;
import com.tfg.tfg_tienda_fisica.modelos.Producto;
import com.tfg.tfg_tienda_fisica.repositorios.ProductoRepositorio;
import com.tfg.tfg_tienda_fisica.utils.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicioImpl implements IProductoServicio {

    @Autowired
    ProductoRepositorio productoRepositorio;

    @Override
    public List<ProductoDTO> obtenerTodo() {

        List<Producto> productos = productoRepositorio.findAll();
        List<ProductoDTO> productosDTO = new ArrayList<>();
        if (!productos.isEmpty()) {

            productosDTO = ModelMapperUtil.transformDtoList(productos, ProductoDTO.class);
        }

        return productosDTO;

    }

    @Override
    public ProductoDTO guardar(ProductoDTO producto) {

        Producto productoEnti = ModelMapperUtil.transformDto(producto, Producto.class);

        return ModelMapperUtil.transformDto(productoRepositorio.save(productoEnti), ProductoDTO.class);

    }

    @Override
    public ProductoDTO obtenerPorId(long id) {

        Optional<Producto> producto = productoRepositorio.findById(id);
        ProductoDTO productoDTO = new ProductoDTO();

        if (producto.isPresent()) {

            productoDTO = ModelMapperUtil.transformDto(producto.get(), ProductoDTO.class);

            return productoDTO;
        } else {

            return null;
        }

    }

    public List<ProductoDTO> findByNombreContaining(String texto){
        List<Producto> productos = productoRepositorio.findByNombreContaining(texto);
        List<ProductoDTO> productosDTO = new ArrayList<>();
        if (!productos.isEmpty()) {

            productosDTO = ModelMapperUtil.transformDtoList(productos, ProductoDTO.class);
        }

        return productosDTO;
    }

    public List<ProductoDTO> findByMarcaId(Long marcaId){

        List<Producto> productos = productoRepositorio.findByMarcaId(marcaId);
        List<ProductoDTO> productosDTO = new ArrayList<>();
        if (!productos.isEmpty()) {

            productosDTO = ModelMapperUtil.transformDtoList(productos, ProductoDTO.class);
        }

        return productosDTO;

    }

    public List<ProductoDTO> findByCategoriaId(Long categoriaId){

        List<Producto> productos = productoRepositorio.findByCategoriaId(categoriaId);
        List<ProductoDTO> productosDTO = new ArrayList<>();
        if (!productos.isEmpty()) {

            productosDTO = ModelMapperUtil.transformDtoList(productos, ProductoDTO.class);
        }

        return productosDTO;

    }

    @Override
    public void eliminar(long id) {
        productoRepositorio.deleteById(id);
    }
}
