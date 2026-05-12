package com.grupo6.biblioteca_digital.model.dto;

import java.time.LocalDateTime;


public record PrestamoDTO(
    Long id,
    String nombreCliente,    // Así React no tiene que buscar en otra tabla
    String tituloLibro,      // Muy útil para mostrar en una tabla de préstamos
    LocalDateTime fechaSalida,
    LocalDateTime fechaDevolucionEsperada,
    String estado
) {}