package com.grupo6.biblioteca_digital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.grupo6.biblioteca_digital.model.entity.LibroEntity;
import com.grupo6.biblioteca_digital.repository.LibroRepository;

@Service
public class LibroServices {
    private final LibroRepository libroRepository;

    public LibroServices(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    // Listar todos los libros
    public List<LibroEntity> listarLibros() {
        return libroRepository.findAll();
    }

    // Guardar un libro
    public LibroEntity guardarLibro(LibroEntity libro) {
        return libroRepository.save(libro);
    }

    // Buscar libro por ID
    public Optional<LibroEntity> buscarPorId(Long id) {
        return libroRepository.findById(id);
    }
    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }

}

