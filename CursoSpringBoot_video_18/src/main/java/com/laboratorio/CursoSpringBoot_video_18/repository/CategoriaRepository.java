package com.laboratorio.CursoSpringBoot_video_18.repository;

import com.laboratorio.CursoSpringBoot_video_18.dto.CategoriaResponse;
import com.laboratorio.CursoSpringBoot_video_18.dto.ProductoResponse;
import com.laboratorio.CursoSpringBoot_video_18.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository
            extends JpaRepository<Categoria,Integer> {

    @Query("""
            SELECT new com.laboratorio.CursoSpringBoot_video_18.dto.CategoriaResponse(c.id,c.nombre)
            FROM Categoria c
            WHERE c.id= :id
            """)
    Optional<CategoriaResponse> findCategoriaById(@Param("id") Integer id);

    @Query("""
            SELECT new com.laboratorio.CursoSpringBoot_video_18.dto.CategoriaResponse(c.id,c.nombre)
            FROM Categoria c
            WHERE c.nombre=:nombre
            """)
    Optional<CategoriaResponse>findOneByNombre(@Param("nombre") String nombre);

    @Query("""
            SELECT new com.laboratorio.CursoSpringBoot_video_18.dto.CategoriaResponse(c.id,c.nombre)
            FROM Categoria c
            ORDER BY c.nombre ASC
            """)
    List<CategoriaResponse> findAllOrderByNombreAsc();

    @Query("""
            SELECT new com.laboratorio.CursoSpringBoot_video_18.dto.CategoriaResponse(c.id,c.nombre)
            FROM Categoria c
            WHERE UPPER(c.nombre) LIKE UPPER(CONCAT('%',:infix,'%'))
            ORDER BY c.nombre ASC
            """)
    List<CategoriaResponse>
        findByNombreContainingIgnoreCaseOrderByNombreAsc(@Param("infix")String infix);

    @Query("""
            SELECT new com.laboratorio.CursoSpringBoot_video_18.dto.ProductoResponse
            (p.id,p.categoriaId,p.nombre,p.precio,p.fechaIngreso)
            FROM Producto p
            WHERE p.categoriaId = :categoriaId
            ORDER BY p.nombre ASC
            """)
    List<ProductoResponse>
        findByCategoriaIdContainingCaseOrderByNombreAsc(@Param("categoriaId")String categoriaId);

}
