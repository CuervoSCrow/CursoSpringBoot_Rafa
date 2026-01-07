package com.laboratorio.CursoSpringBoot_video_08.controller;

import com.laboratorio.CursoSpringBoot_video_08.model.Producto;
import com.laboratorio.CursoSpringBoot_video_08.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductoRestController {
/*
    private final ProductoService productoService;

    @GetMapping("/productos/{id}")
    public Producto findById(@PathVariable Integer id){
        return productoService.findById(id);
    }

    @GetMapping("/productos")
    public List<Producto> findAll(){
        return productoService.findAll();
    }

    @PostMapping("/productos")
    public Producto create(@RequestBody Producto producto){
        return productoService.create(producto);
    }

    @PutMapping("/productos/{id}")
    public Producto update(@PathVariable Integer id,
                           @RequestBody Producto producto){
        return productoService.update(id,producto);
    }

    @DeleteMapping("productos/{id}")
    public String delete(@PathVariable Integer id){
        return productoService.delete(id);
    }

 */

//    En Estrategias de inyeccion de dependencias video 8
//    Esta parte de codigo es usada con la implementacion de Mapas
//    o Listas

    private final List<ProductoService> productoService;
    private final Integer opc=1;

    @GetMapping("/productos/{id}")
    public Producto findById(@PathVariable Integer id){
        return productoService.get(opc).findById(id);
    }

    @GetMapping("/productos")
    public List<Producto> findAll(){
        return productoService.get(opc).findAll();
    }

    @PostMapping("/productos")
    public Producto create(@RequestBody Producto producto){
        return productoService.get(opc).create(producto);
    }

    @PutMapping("/productos/{id}")
    public Producto update(@PathVariable Integer id,
                           @RequestBody Producto producto){
        return productoService.get(opc).update(id,producto);
    }

    @DeleteMapping("productos/{id}")
    public String delete(@PathVariable Integer id) {
        return productoService.get(opc).delete(id);
    }

}
