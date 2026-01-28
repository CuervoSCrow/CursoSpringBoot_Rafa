package com.laboratorio.CursoSpringBoot_video_17.repository;

import com.laboratorio.CursoSpringBoot_video_17.dto.ProductoDTO;
import com.laboratorio.CursoSpringBoot_video_17.dto.ProductoProjection;
import com.laboratorio.CursoSpringBoot_video_17.dto.ProductoRecord;
import com.laboratorio.CursoSpringBoot_video_17.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository
        extends JpaRepository<Producto,Integer> {

//    Proyecciones personalizadas
    @Query("""
            SELECT new com.laboratorio.CursoSpringBoot_video_17.dto.ProductoDTO
             (p.codigo, p.nombre, p.categoria.nombre)
            FROM Producto p
            ORDER BY p.nombre ASC
            """)
    List<ProductoDTO> findListadoProductosDTO();


    //    Proyecciones personalizadas Record
    @Query("""
            SELECT new com.laboratorio.CursoSpringBoot_video_17.dto.ProductoRecord
             (p.codigo, p.nombre, p.categoria.nombre)
            FROM Producto p
            ORDER BY p.nombre ASC
            """)
    List<ProductoRecord> findListadoProductosRecord();

//    Proyecciones personalizadas Datos Crudos
    @Query("""
            SELECT p.codigo, p.nombre, p.categoria.nombre
            FROM Producto p
            ORDER BY p.nombre ASC
            """)
    List<Object[]> findListadoProductosObject();

//
    @Query("""
            SELECT p.codigo AS codigo, p.nombre AS nombre,
            p.categoria.nombre AS categoria
            FROM Producto p
            ORDER BY p.nombre ASC
            """)
    List<ProductoProjection> findListadoProductosProjection();
}
