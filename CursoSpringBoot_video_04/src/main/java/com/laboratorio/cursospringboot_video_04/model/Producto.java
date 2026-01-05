package com.laboratorio.cursospringboot_video_04.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    private Integer codigo;
    private String nombre;
    private double precio;
}
