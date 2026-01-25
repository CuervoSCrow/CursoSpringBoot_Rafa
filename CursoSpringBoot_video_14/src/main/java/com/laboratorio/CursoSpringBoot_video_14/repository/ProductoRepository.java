package com.laboratorio.CursoSpringBoot_video_14.repository;

import com.laboratorio.CursoSpringBoot_video_14.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
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
}
