package com.grupo6.biblioteca_digital.Controller;

import com.grupo6.biblioteca_digital.model.dto.CompraCreateDTO;
import com.grupo6.biblioteca_digital.model.dto.CompraDTO;
import com.grupo6.biblioteca_digital.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compras")
@CrossOrigin(origins = "*")
public class CompraController {

    @Autowired
    private CompraService compraService;

    // Obtener todas las compras
    @GetMapping
    public List<CompraDTO> listar() {
        return compraService.listarCompras();
    }

    // Guardar una nueva compra (Recibe CreateDTO)
    @PostMapping
    public ResponseEntity<CompraDTO> guardar(@RequestBody CompraCreateDTO compraDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(compraService.registrarCompra(compraDto));
    }

    // Obtener una compra por ID
    @GetMapping("/{id}")
    public ResponseEntity<CompraDTO> obtenerUno(@PathVariable Long id) {
        CompraDTO compra = compraService.buscarPorId(id);
        return compra != null ? ResponseEntity.ok(compra) : ResponseEntity.notFound().build();
    }

    // Actualizar una compra existente (Recibe CreateDTO)
    @PutMapping("/{id}")
    public ResponseEntity<CompraDTO> actualizar(@PathVariable Long id, @RequestBody CompraCreateDTO compraDto) {
        CompraDTO actualizada = compraService.actualizarCompra(id, compraDto);
        return actualizada != null ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }

    // Eliminar una compra
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = compraService.eliminarCompra(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}