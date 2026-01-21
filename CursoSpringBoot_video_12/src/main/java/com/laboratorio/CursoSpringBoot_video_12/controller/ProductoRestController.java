package com.laboratorio.CursoSpringBoot_video_12.controller;

import com.laboratorio.CursoSpringBoot_video_12.model.Producto;
import com.laboratorio.CursoSpringBoot_video_12.service.ProductoService;
import com.laboratorio.CursoSpringBoot_video_12.util.exception.InvalidDataException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
        Optional<Producto> producto = this.productoService.findById(id);
        if(producto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se ha encontrado el producto con id: "+id);
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

    @PostMapping("/productos")
    public ResponseEntity<?> create(@RequestBody Producto producto){
        try{
            Producto productoNuevo = this.productoService.create(producto);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id")
                    .buildAndExpand(productoNuevo.getCodigo())
                    .toUri();
            return ResponseEntity.created(location)
                    .body(productoNuevo);
        }catch(InvalidDataException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping(value="/productos/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,
                                    @RequestBody Producto producto){
        try{
            Optional<Producto> productoAModificar =
                    this.productoService.update(id,producto);
            if(productoAModificar.isEmpty()){
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(productoAModificar.get());
        }catch(InvalidDataException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/productos/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        try{
            if(this.productoService.delete(id)){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se ha encontrado el producto con id: "+id);
        }catch(Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
