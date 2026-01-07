package com.laboratorio.CursoSpringBoot_video_08.config;

import com.laboratorio.CursoSpringBoot_video_08.service.ProductoService;
import com.laboratorio.CursoSpringBoot_video_08.service.ProductoServiceImpl_01;
import com.laboratorio.CursoSpringBoot_video_08.service.ProductoServiceImpl_02;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductoServiceConfig {
//    @Bean
//    public ProductoService productoService(){
////        Logica que permite decidir el bean a inyectar
//        double aleatorio = Math.random();
//        if(aleatorio <= 0.5){
//            System.out.println("Se inyecta la implementacion 1");
//            return new ProductoServiceImpl_01();
//        }else{
//            System.out.println("Se inyecta la implementacion 2");
//            return new ProductoServiceImpl_02();
//        }
//    }
}
