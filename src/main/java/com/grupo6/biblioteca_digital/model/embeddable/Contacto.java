package com.grupo6.biblioteca_digital.model.embeddable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Contacto {
    private String telefono;
    private String direccion;
    private String email;
}
