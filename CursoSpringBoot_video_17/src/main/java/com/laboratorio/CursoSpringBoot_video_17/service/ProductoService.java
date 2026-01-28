package com.laboratorio.CursoSpringBoot_video_17.service;

import com.laboratorio.CursoSpringBoot_video_17.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    Optional<Producto> findById(Integer id);
    List<Producto> findAll();
    Producto create(Producto producto);
    Optional<Producto> update(
            Integer id,Producto producto);
    boolean delete(Integer id);
}
