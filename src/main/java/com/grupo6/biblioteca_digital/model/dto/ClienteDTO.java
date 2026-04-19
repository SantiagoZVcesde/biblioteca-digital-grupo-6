package com.grupo6.biblioteca_digital.model.dto;

import com.grupo6.biblioteca_digital.Enums.TipoIdentidad;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private TipoIdentidad tipoIdentidad;
    private String numeroIdentidad;
    private String email;
    private String direccion;
    private String telefono;
}
