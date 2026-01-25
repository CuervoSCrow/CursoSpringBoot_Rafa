package com.laboratorio.CursoSpringBoot_video_14.service;

import com.laboratorio.CursoSpringBoot_video_14.model.Producto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    Optional<Producto> findById(Integer id);
    List <Producto> findAll();
    Producto create(Producto producto);
    Optional<Producto> update(Integer id,
                              Producto producto);
    boolean delete(Integer id);
}
