package com.laboratorio.CursoSpringBoot_video_07.controller;

import com.laboratorio.CursoSpringBoot_video_07.model.Producto;
import com.laboratorio.CursoSpringBoot_video_07.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ProductoRestController {

    /*
    public ProductoRestController(
            @Qualifier("implementacion_1")
            ProductoService productoService) {
        this.productoService = productoService;
    }
    */
    private final ProductoService productoService;

    @GetMapping(value = "/productos/{id}")
    public Producto findById(@PathVariable Integer id){
        return this.productoService.findById(id);
    }
    @GetMapping(value = "/productos")
    public List<Producto> findAll(){
        return this.productoService.findAll();
    }
    @PostMapping(value = "/productos")
    public Producto create(@RequestBody Producto producto){
        return productoService.create(producto);
    }
    @PutMapping(value = "/productos/{id}")
    public Producto update(@PathVariable Integer id,
                           @RequestBody Producto producto){
        return this.productoService.update(id,producto);
    }
    @DeleteMapping(value = "/productos/{id}")
    public String delete(@PathVariable Integer id){
        return this.productoService.delete(id);
    }
}
