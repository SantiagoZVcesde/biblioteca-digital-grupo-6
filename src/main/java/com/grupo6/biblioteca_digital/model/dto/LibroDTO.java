package com.grupo6.biblioteca_digital.model.dto;

import com.grupo6.biblioteca_digital.Enums.EstadoLibro;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LibroDTO {
    
    private Long id;
    private String titulo;

    private Integer cantidad;
    private Double precio;
    private EstadoLibro estado;
    private String categoria;
  
}