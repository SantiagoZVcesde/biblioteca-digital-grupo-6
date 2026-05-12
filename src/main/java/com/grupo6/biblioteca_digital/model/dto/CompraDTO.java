package com.grupo6.biblioteca_digital.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CompraDTO(
    Long id,
    Long clienteId,
    Long libroId,
    String tituloLibro,
    String proveedor,
    BigDecimal monto,
    Integer cantidad,
    LocalDateTime fechaRegistro
) {}