package com.laboratorio.CursoSpringBoot_video_07.service;

import com.laboratorio.CursoSpringBoot_video_07.model.Producto;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@Primary
@Service("implementacion_1")
@ConditionalOnProperty(
        name="implementacion.producto.service",
        havingValue = "implementacion1",
        matchIfMissing = true)
public class ProductoServiceImpl_01
        implements ProductoService{

    private List<Producto> productos = new ArrayList<>(
            List.of(
                    new Producto(1,"Mouse",25),
                    new Producto(2,"Teclado", 22),
                    new Producto(3,"Monitor",120)
            ));

    @Override
    public Producto findById(Integer id) {
        return productos.stream()
                .filter(p->p.getCodigo().equals(id))
                .findAny()
                .orElseThrow();
    }

    @Override
    public List<Producto> findAll() {
        return productos;
    }

    @Override
    public Producto create(Producto producto) {
        productos.add(producto);
        return producto;
    }

    @Override
    public Producto update(Integer id, Producto producto) {
        Producto productoAModificar = this.findById(id);
        productoAModificar.setNombre(producto.getNombre());
        productoAModificar.setPrecio(producto.getPrecio());
        return productoAModificar;
    }

    @Override
    public String delete(Integer id) {
        Producto productoAEliminar = this.findById(id);

        productos.remove(productoAEliminar);
        return "Impl_01: Se ha eliminado el producto "+productoAEliminar.getNombre();
    }
}
