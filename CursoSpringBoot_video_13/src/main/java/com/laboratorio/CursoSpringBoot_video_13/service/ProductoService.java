package com.laboratorio.CursoSpringBoot_video_13.service;

import com.laboratorio.CursoSpringBoot_video_13.model.Producto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ProductoService {
    Optional<Producto> findById(Integer id);
    List<Producto> findAll();
    Producto create(Producto producto);
    Optional<Producto> update(Integer id,
                              Producto producto);
    boolean delete(Integer id);

}
