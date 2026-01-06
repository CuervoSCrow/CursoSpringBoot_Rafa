package com.laboratorio.CursoSpringBoot_video_06.controller;

import com.laboratorio.CursoSpringBoot_video_06.model.Producto;
import com.laboratorio.CursoSpringBoot_video_06.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
public class ProductoRestController {
//      Forma 1 de Inyeccion
//    Inyeccion por Autowired
    /*
    @Autowired
    private ProductoService productoService;
    */

//    Forma 2 de Inyeccion por Setter
    //    Inyeccion por Setter
    /*
    private ProductoService productoService;

    @Autowired
    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }

     */

//    Forma 3 y la que se va utilizar
//    Inyeccion por Constructor
    /*
    private final ProductoService productoService;
    public ProductoRestController(ProductoService productoService) {
        this.productoService=productoService;
    }

     */
//    La forma 3 usada con lombok se coloca la anotacion @RequiredArgsConstructor
//    Asi que toda declaracion final se va agregar un constructor

    private final ProductoService productoService;

    @GetMapping(value = "/productos/{id}")
    public Producto findById(@PathVariable Integer id){
        return this.productoService.findById(id);
    }
    @GetMapping(value = "/productos")
    public List<Producto> findAll(){
        return this.productoService.findAll();
    }
    @PostMapping(value="/productos")
    public Producto create(@RequestBody Producto producto){
        return productoService.create(producto);
    }
    @PutMapping(value = "/productos/{id}")
    public Producto update(@PathVariable Integer id,
                    @RequestBody Producto producto){
        return this.productoService.update(id,producto);
    }

    @DeleteMapping(value = "/productos/{id}")
    public String delete(@PathVariable Integer id)
    {
        return this.productoService.delete(id);
    }

}
