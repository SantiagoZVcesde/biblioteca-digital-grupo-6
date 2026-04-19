package com.grupo6.biblioteca_digital.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    

    @GetMapping("/")
    public String saludo() {
        return "Hola, bienvenido a la Biblioteca Digital!";
    }
}
