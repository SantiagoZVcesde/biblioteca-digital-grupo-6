package com.grupo6.biblioteca_digital.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "compras")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Compra extends BaseEntity {

    @Column(nullable = false)
    private String proveedor;

    @Column(nullable = false)
    private BigDecimal monto;

    @Column(nullable = false)
    private Integer cantidad;

}