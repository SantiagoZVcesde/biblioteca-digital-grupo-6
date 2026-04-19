package com.grupo6.biblioteca_digital.model.entity;

import com.grupo6.biblioteca_digital.Enums.EstadoLibro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "libros")
public class LibroEntity extends BaseEntity{
    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "autor", nullable = false)
    private String autor;
    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;
    @Column(name = "editorial", nullable = false)
    private String editorial;

    @Enumerated(EnumType.STRING)
    private EstadoLibro estado;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaEntity categoria;
}
