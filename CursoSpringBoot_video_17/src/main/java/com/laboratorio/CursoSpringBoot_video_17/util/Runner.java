package com.laboratorio.CursoSpringBoot_video_17.util;

import com.laboratorio.CursoSpringBoot_video_17.dto.ProductoDTO;
import com.laboratorio.CursoSpringBoot_video_17.dto.ProductoProjection;
import com.laboratorio.CursoSpringBoot_video_17.dto.ProductoRecord;
import com.laboratorio.CursoSpringBoot_video_17.repository.ProductoRepository;
import com.laboratorio.CursoSpringBoot_video_17.service.ProductoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

    private final ProductoService productoService;
    private final ProductoRepository productoRepository;

    @Override
    public void run(String... args) throws Exception {

//        Proyecciones Personalizadas DTO
        log.info("***********************************************************");
        log.info("Ejemplo de proyección personalizadas por constructor: DTO");
        log.info("***********************************************************");
        List<ProductoDTO> productosDTO = productoRepository.findListadoProductosDTO();
        for(ProductoDTO p : productosDTO){
            log.info("Producto DTO: {}",p.toString());
        }

//      Proyecciones Personalizadas Record
        log.info("***********************************************************");
        log.info("Ejemplo de proyección personalizadas por constructor: Record");
        log.info("***********************************************************");
        List<ProductoRecord> productosRecord = productoRepository.findListadoProductosRecord();
        for (ProductoRecord p : productosRecord){
            log.info("Producto Record: {}",p.toString());
        }

        //      Proyecciones Personalizadas Datos en crudo
        log.info("***********************************************************");
        log.info("Ejemplo de proyección personalizadas usando datos en crudo");
        log.info("***********************************************************");
        List<Object[]> productosObject = productoRepository.findListadoProductosObject();
        for (Object[] p : productosObject){
            log.info("Producto Object: id: {},nombre{},categoria: {}",p[0],p[1],p[2]);
        }

        //      Proyecciones Personalizadas Datos en crudo
        log.info("*****************************************************************");
        log.info("Ejemplo de proyección personalizadas usando closed projection");
        log.info("*****************************************************************");
        List<ProductoProjection> productosProjection =
                productoRepository.findListadoProductosProjection();
        for (ProductoProjection p : productosProjection){
            log.info("Producto Object: id: {},nombre{},categoria: {}",
                    p.getCodigo(),
                    p.getNombre(),
                    p.getCategoria());
        }

    }
}
