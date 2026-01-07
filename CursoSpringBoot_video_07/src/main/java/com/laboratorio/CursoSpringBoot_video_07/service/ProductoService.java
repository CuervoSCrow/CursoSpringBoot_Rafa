package com.laboratorio.CursoSpringBoot_video_07.service;

import com.laboratorio.CursoSpringBoot_video_07.model.Producto;

import java.util.List;

public interface ProductoService {
    Producto findById(Integer id);
    List<Producto> findAll();
    Producto create(Producto producto);
    Producto update(Integer id, Producto producto);
    String delete(Integer id);

}
