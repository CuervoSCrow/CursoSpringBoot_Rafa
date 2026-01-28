package com.laboratorio.CursoSpringBoot_video_17.util.exception;

public class InvalidDataException extends RuntimeException{
    public InvalidDataException(String massage){
        super(massage);
    }
}
