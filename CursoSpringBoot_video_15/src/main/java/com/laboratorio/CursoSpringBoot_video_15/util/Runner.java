package com.laboratorio.CursoSpringBoot_video_15.util;

import com.laboratorio.CursoSpringBoot_video_15.model.Producto;
import com.laboratorio.CursoSpringBoot_video_15.repository.ProductoRepository;
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
    public void run(String... args)throws Exception{
        String nombre="monitor";
        String infix="ni";
        log.info("Ejecutando Runner... ");

        log.info("Metodo findOneByNombre");
        Optional<Producto> producto= productoRepository.findOneByNombre(nombre);
        if(producto.isEmpty()){
            log.info("No se encontro el producto: {}",nombre);
        }else{
            log.info("Producto: {}",producto.get().toString());
        }

        log.info("Metodo findOneByNombreIgnoreCase");
        producto = productoRepository.findOneByNombreIgnoreCase(nombre);
        if(producto.isEmpty()){
            log.info("No encontre el producto: {}",nombre);
        }else{
            log.info("Producto Encontrado: {}",producto.get().toString());
        }

        log.info("Metodo findOneNombreContainingIgnoreCaseOrderByNombreAsc");
        List<Producto> productos=
                productoRepository.findByNombreContainingIgnoreCaseOrderByNombreAsc(infix);
        for(Producto p : productos){
            log.info("Producto con infix {}: {}",infix,p.toString());
        }

//        int result= productoRepository.updateCategoriaProductos(2,1);
//        log.info("Se han modificados: {} registros.",result);
//
//        result= productoRepository.deleteproductosByCategoria(1);
//        log.info("Se han eliminado: {} registros.",result);

        long result = productoRepository.deleteByCategoriaId(1);
        log.info("Se han eliminado: {} registros.",result);

    }
}
