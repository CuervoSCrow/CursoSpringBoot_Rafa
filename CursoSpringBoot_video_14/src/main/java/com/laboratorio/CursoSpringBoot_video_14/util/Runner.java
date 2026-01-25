package com.laboratorio.CursoSpringBoot_video_14.util;

import com.laboratorio.CursoSpringBoot_video_14.model.Producto;
import com.laboratorio.CursoSpringBoot_video_14.repository.ProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class Runner implements CommandLineRunner {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public void run(String... args) throws   Exception{
        String nombre="monitor";
        String infix="ni";

        log.info("Ejecutando Runner...");
        log.info("Metodo findOneByNombre");
        Optional<Producto> producto= productoRepository.findOneByNombre(nombre);
        if(producto.isEmpty()){
            log.info("No encontre el producto");
        }else{
            log.info("Producto: {}",producto.get().toString());
        }

        log.info("Metodo findOneByNombreIgnoreCase");
        producto = productoRepository.findOneByNombreIgnoreCase(nombre);
        if(producto.isEmpty()){
            log.info("No encontre el producto");
        }else{
            log.info("Producto: {}",producto.get().toString());
        }

        log.info("Metodo findOneByNombreContainingIgnoreCaseOrderByNombreAsc");
        List<Producto> productos=
                productoRepository.findByNombreContainingIgnoreCaseOrderByNombreAsc(infix);
        for(Producto p :productos){
            log.info("Producto con infix {}: {}",infix,p.toString());
        }
    }
}
