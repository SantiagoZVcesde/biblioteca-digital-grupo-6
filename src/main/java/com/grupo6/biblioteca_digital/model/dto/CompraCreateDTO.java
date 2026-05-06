package com.grupo6.biblioteca_digital.model.dto;

import java.math.BigDecimal;

public record CompraCreateDTO(
    String proveedor,
    BigDecimal monto,
    Integer cantidad
) {}