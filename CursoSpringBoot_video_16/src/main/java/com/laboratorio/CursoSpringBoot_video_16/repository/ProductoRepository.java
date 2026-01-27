package com.laboratorio.CursoSpringBoot_video_16.repository;

import com.laboratorio.CursoSpringBoot_video_16.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductoRepository
        extends JpaRepository<Producto,Integer> {

    @Query(value = """
            SELECT * 
            FROM productos 
            WHERE categoria_id= :categoriaId
            AND UPPER(nombre) LIKE UPPER('%' || :infix || '%')
            ORDER BY codigo ASC
            """,nativeQuery = true)
    List<Producto> findByCategroiaAndNombreSQL(
            @Param("categoriaId") Integer categoriaId,
            @Param("infix") String infix
    );

    @Query(value = """
            UPDATE productos SET
            categoria_id= :idDestino
            WHERE categoria_id= :idOrigen
            """,nativeQuery = true)
    @Modifying
    @Transactional
    int updateCategoriaProductosSQL(
            @Param("idOrigen") Integer idOrigen,
            @Param("idDestino") Integer idDestino
    );

    @Query(value= """
            DELETE FROM productos
            WHERE categoria_id= :categoriaId
            """,nativeQuery = true)
    @Modifying
    @Transactional
    int deleteProductosByCategoriaSQL(
            @Param("categoriaId") Integer categoriaId
    );
}
