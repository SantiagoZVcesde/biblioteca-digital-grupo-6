package com.grupo6.biblioteca_digital.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo6.biblioteca_digital.model.entity.LibroEntity;
import com.grupo6.biblioteca_digital.service.LibroServices;




@RestController
@RequestMapping("/api/Libro")
public class LibroControllador {
        private final LibroServices libroServices;

    public LibroControllador(LibroServices libroServices) {
        this.libroServices = libroServices;
    }

    // Listar todos los libros
    @GetMapping
    public List<LibroEntity> listarLibros() {
        return libroServices.listarLibros();
    }

    // Guardar un libro
    @PostMapping
    public LibroEntity guardarLibro(@RequestBody LibroEntity libro) {
        return libroServices.guardarLibro(libro);
    }

    // Buscar libro por ID
    @GetMapping("/{id}")
    public Optional<LibroEntity> buscarPorId(@PathVariable Long id) {
        return libroServices.buscarPorId(id);
    }

    // Eliminar libro por ID
    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        libroServices.eliminarLibro(id);
    }

}
