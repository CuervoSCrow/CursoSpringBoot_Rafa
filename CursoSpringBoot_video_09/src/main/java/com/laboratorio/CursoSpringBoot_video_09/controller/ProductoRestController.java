package com.laboratorio.CursoSpringBoot_video_09.controller;

import com.laboratorio.CursoSpringBoot_video_09.model.Producto;
import com.laboratorio.CursoSpringBoot_video_09.service.ProductoService;
import jakarta.servlet.Servlet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductoRestController {

    private final ProductoService productoService;

    @GetMapping("/productos/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        Optional <Producto> producto = this.productoService.findById(id);
        if(producto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontro el producto con id: "+id);
        }
        return ResponseEntity.ok(producto.get());
    }

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> findAll(){
        List<Producto> productos = this.productoService.findAll();
        if(productos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productos);
    }

    @PostMapping("productos")
    public ResponseEntity<Producto> create(@RequestBody Producto producto){
        Producto productoNuevo=this.productoService.create(producto);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productoNuevo.getCodigo())
                .toUri();

        return ResponseEntity.created(location)
                .body(productoNuevo);

    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> update(@PathVariable Integer id,
                           @RequestBody Producto producto){
        Optional<Producto> productoAModificar = this.productoService.update(id,producto);
        if(productoAModificar.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productoAModificar.get());
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        if(this.productoService.delete(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No se encontro el producto con id: "+id);
    }
}
