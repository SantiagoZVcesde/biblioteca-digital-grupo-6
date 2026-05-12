package com.grupo6.biblioteca_digital.model.dto;

import java.math.BigDecimal;

public record CompraCreateDTO(
    Long clienteId,
    Long libroId,
    String proveedor,
    BigDecimal monto,
    Integer cantidad
) {}