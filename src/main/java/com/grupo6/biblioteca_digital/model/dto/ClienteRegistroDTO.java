package com.grupo6.biblioteca_digital.model.dto;

import com.grupo6.biblioteca_digital.Enums.Rol;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteRegistroDTO extends ClienteDTO {
    private String password; // <--- La clave que enviarás desde Postman
    private Rol rol;         // <--- "ADMIN" o "CLIENTE"
}
