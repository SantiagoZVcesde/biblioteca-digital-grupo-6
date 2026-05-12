package com.grupo6.biblioteca_digital.model.dto;


public record PrestamoCreateDTO(
    Long clienteId,
    Long libroId,
    Integer diaPrestamo //cantidad de días que se prestará el libro ejemplo: 7, 14, 30
) {} 
