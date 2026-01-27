package com.laboratorio.CursoSpringBoot_video_15.repository;

import com.laboratorio.CursoSpringBoot_video_15.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ProductoRepository
        extends JpaRepository<Producto,Integer> {

    Optional<Producto> findOneByNombre(String nombre);
    Optional<Producto> findOneByNombreIgnoreCase(String nombre);

    List<Producto> findByNombreContaining(String infix);
    List<Producto> findByNombreContainingIgnoreCase(String infix);
    List<Producto> findByNombreContainingIgnoreCaseOrderByNombreAsc(String infix);
    List<Producto> findByNombreStartingWithIgnoreCaseOrderByNombreDesc(String prefix);
    List<Producto> findByCategoriaIdOrderByCodigoAsc(Integer categoriaId);
    List<Producto> findByCategoriaIdAndNombreContainingIgnoreCaseOrderByCodigoAsc(Integer categoriaId,String infix);
    List<Producto> findByPrecioLessThanOrderByCodigoAsc(Double precio);
    List<Producto> findByPrecioGreaterThanEqualOrderByCodigoAsc(Double precio);
    List<Producto> findByFechaIngresoAfter(LocalDate date);
    List<Producto> findByFechaIngresoBefore(LocalDate date);
    List<Producto> findByFechaIngresoBetween(LocalDate dateMin, LocalDate dateMax);

    List<Producto> findTop3ByNombreContainingIgnoreCaseOrderByNombreAsc(String infix);
    Optional<Producto> findFirstByNombreContainingIgnoreCaseOrderByNombreAsc(String infix);

    List<Producto> findByCategoriaIdIn(List<Integer> ids);

    @Query("""
        SELECT p FROM Producto p
        WHERE p.categoriaId = :categoriaId
        AND UPPER(p.nombre) LIKE UPPER(CONCAT('%',:infix,'%'))
        ORDER BY p.codigo ASC
    """)
    List<Producto> findByCategoriaAndNombre(@Param("categoriaId") Integer categoriaId,
                                            @Param("infix") String infix);

    @Query("""
            UPDATE Producto p SET
               p.categoriaId = :idDestino
               WHERE p.categoriaId = :idOrigen
            """)
    @Modifying
    @Transactional
    int updateCategoriaProductos(@Param("idOrigen") Integer idOrigen,
                                 @Param("idDestino") Integer idDestino);

    @Query("""
            DELETE FROM Producto p
            WHERE p.categoriaId = :categoriaId 
            """)
    @Modifying
    @Transactional
    int deleteproductosByCategoria(@Param ("categoriaId") Integer categoriaId);

    @Transactional
    long deleteByCategoriaId(Integer categoriaId);
}
