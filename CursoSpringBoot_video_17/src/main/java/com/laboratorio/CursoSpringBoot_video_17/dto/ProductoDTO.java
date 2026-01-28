package com.laboratorio.CursoSpringBoot_video_17.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class ProductoDTO {
    private Integer codigo;
    private String nombre;
    private String categoria;

    @Override
    public String toString() {
        return "ProductoDTO{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
