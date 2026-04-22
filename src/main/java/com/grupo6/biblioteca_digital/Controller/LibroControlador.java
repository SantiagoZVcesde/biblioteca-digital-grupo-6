package com.grupo6.biblioteca_digital.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo6.biblioteca_digital.Enums.EstadoLibro;
import com.grupo6.biblioteca_digital.model.entity.CategoriaEntity;
import com.grupo6.biblioteca_digital.model.entity.LibroEntity;
import com.grupo6.biblioteca_digital.repository.CategoriaRepository;
import com.grupo6.biblioteca_digital.repository.LibroRepository;
import com.grupo6.biblioteca_digital.service.LibroServices;




@RestController
@RequestMapping("/api/libro")
public class LibroControlador {

    private final LibroServices libroServices;
    private final LibroRepository libroRepository;
    private final CategoriaRepository categoriaRepository;

    @Autowired
    public LibroControlador(LibroServices libroServices,
                            LibroRepository libroRepository,
                            CategoriaRepository categoriaRepository) {
        this.libroServices = libroServices;
        this.libroRepository = libroRepository;
        this.categoriaRepository = categoriaRepository;
    }

    // Listar todos los libros
    @GetMapping
    public List<LibroEntity> listarLibros() {
        return libroServices.listarLibros();
    }

    // Guardar un libro
    @PostMapping
    public LibroEntity crearLibro(@RequestBody LibroEntity libro) {
        // Buscar categoría por nombre
    CategoriaEntity categoria = categoriaRepository.findByNombre(libro.getCategoria().getNombre())
        .orElseGet(() -> {
            CategoriaEntity nuevaCategoria = new CategoriaEntity();
        nuevaCategoria.setNombre(libro.getCategoria().getNombre());
        nuevaCategoria.setDescripcion("Categoría creada automáticamente");
        return categoriaRepository.save(nuevaCategoria);
    });

        libro.setCategoria(categoria);

        // Estado por defecto con enum
        if (libro.getEstado() == null) {
            libro.setEstado(EstadoLibro.DISPONIBLE);
        }

        return libroRepository.save(libro);
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
