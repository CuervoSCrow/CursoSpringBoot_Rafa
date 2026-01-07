package com.laboratorio.CursoSpringBoot_video_08.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    private Integer codigo;
    private String nombre;
    private double precio;
}
