package com.laboratorio.CursoSpringBoot_video_13.repository;

import com.laboratorio.CursoSpringBoot_video_13.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
