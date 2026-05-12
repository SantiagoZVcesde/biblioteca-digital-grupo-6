package com.grupo6.biblioteca_digital.Controller;

import com.grupo6.biblioteca_digital.model.dto.PrestamoCreateDTO;
import com.grupo6.biblioteca_digital.model.dto.PrestamoDTO;
import com.grupo6.biblioteca_digital.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
@CrossOrigin(origins = "*") // Permite que tu frontend en React se conecte sin bloqueos
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    // 1. Obtener todos los préstamos
    @GetMapping
    public ResponseEntity<List<PrestamoDTO>> listar() {
        return ResponseEntity.ok(prestamoService.listarTodos());
    }

    // 2. Obtener un préstamo por ID
    @GetMapping("/{id}")
    public ResponseEntity<PrestamoDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(prestamoService.buscarPorId(id));
    }

    // 3. Crear un nuevo préstamo
    // Aquí es donde sucede la "magia" de descontar stock
    @PostMapping
    public ResponseEntity<PrestamoDTO> crear(@RequestBody PrestamoCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(prestamoService.registrarPrestamo(dto));
    }

    // 4. Marcar como devuelto
    // Usamos PATCH o PUT porque estamos modificando un recurso existente
    @PutMapping("/{id}/devolucion")
    public ResponseEntity<String> devolver(@PathVariable Long id) {
        prestamoService.devolverLibro(id);
        return ResponseEntity.ok("Libro devuelto exitosamente. El stock ha sido actualizado.");
    }
}