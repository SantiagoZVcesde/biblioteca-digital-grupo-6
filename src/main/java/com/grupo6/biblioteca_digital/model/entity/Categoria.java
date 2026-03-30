package com.grupo6.biblioteca_digital.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

//sera un clase ya que pueden variar los generos en algun futuro, y se pueden agregar mas categorias, ademas de que cada libro puede tener una categoria diferente, por lo que es necesario crear una clase para manejar esta informacion de manera mas eficiente y organizada.

@Getter
@Setter
@Entity
@Table(name = "categorias")
@NoArgsConstructor
@AllArgsConstructor
public class Categoria extends BaseEntity {

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;
    
    @Column(name = "descripcion")
    private String descripcion;
    
}