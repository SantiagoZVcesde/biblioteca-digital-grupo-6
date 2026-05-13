package com.grupo6.biblioteca_digital.Controller;



import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo6.biblioteca_digital.model.dto.LibroDTO;
import com.grupo6.biblioteca_digital.service.LibroServices;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroServices libroServices;

    public LibroController(LibroServices libroServices) {
        this.libroServices = libroServices;
    }

    // =========================
    // LISTAR
    // =========================

    @GetMapping
    public List<LibroDTO> listarLibros() {

        return libroServices.listarLibrosDTO();
    }

    // =========================
    // BUSCAR POR ID
    // =========================

    @GetMapping("/{id}")
    public ResponseEntity<LibroDTO> buscarPorId(
            @PathVariable Long id) {

        Optional<LibroDTO> libro =
                libroServices.buscarPorId(id);

        return libro
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // =========================
    // CREAR
    // =========================

    @PostMapping
    public ResponseEntity<LibroDTO> crearLibro(
            @RequestBody LibroDTO libroDTO) {

        LibroDTO nuevo =
                libroServices.guardarLibroDTO(libroDTO);

        return ResponseEntity.ok(nuevo);
    }

    // =========================
    // ACTUALIZAR
    // =========================

    @PutMapping("/{id}")
    public ResponseEntity<LibroDTO> actualizarLibro(
            @PathVariable Long id,
            @RequestBody LibroDTO libroDTO) {

        LibroDTO actualizado =
                libroServices.actualizarLibro(id, libroDTO);

        return ResponseEntity.ok(actualizado);
    }

    // =========================
    // ELIMINAR
    // =========================

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarLibro(
            @PathVariable Long id) {

        libroServices.eliminarLibro(id);

        return ResponseEntity.ok("Libro eliminado");
    }
}
