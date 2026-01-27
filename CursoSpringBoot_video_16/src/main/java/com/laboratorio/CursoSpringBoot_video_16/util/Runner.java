package com.laboratorio.CursoSpringBoot_video_16.util;

import com.laboratorio.CursoSpringBoot_video_16.model.Producto;
import com.laboratorio.CursoSpringBoot_video_16.repository.ProductoRepository;
import com.laboratorio.CursoSpringBoot_video_16.service.ProductoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class Runner implements CommandLineRunner{


    private final ProductoService productoService;
    private final ProductoRepository productoRepository;

    @Override
    public void run(String... args) throws Exception {

        int result = productoRepository.updateCategoriaProductosSQL(1,2);
        log.info("Se ha modificado: {} registros.",result);

        Integer categoriaId=2;
        String nombre="mOUSe";

        List<Producto> productos1 = productoRepository.findByCategroiaAndNombreSQL(categoriaId,nombre);
        for(Producto p : productos1){
            log.info("Producto: "+p);
        }

        result = productoRepository.deleteProductosByCategoriaSQL(1);
                log.info("Se ha eliminado: {} registros.",result);
    }
}
