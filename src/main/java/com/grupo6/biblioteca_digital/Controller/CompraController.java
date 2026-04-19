package com.grupo6.biblioteca_digital.Controller;

import com.grupo6.biblioteca_digital.model.entity.Compra;
import com.grupo6.biblioteca_digital.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Compra> listar() {
        return compraService.listarCompras();
    }

    // Guardar una nueva compra
    @PostMapping
    public ResponseEntity<Compra> guardar(@RequestBody Compra compra) {
        return ResponseEntity.ok(compraService.registrarCompra(compra));
    }

    // Obtener una compra por ID
    @GetMapping("/{id}")
    public ResponseEntity<Compra> obtenerUno(@PathVariable Long id) {
        Compra compra = compraService.buscarPorId(id);
        return compra != null ? ResponseEntity.ok(compra) : ResponseEntity.notFound().build();
    }

    // Actualizar una compra existente
    @PutMapping("/{id}")
    public ResponseEntity<Compra> actualizar(@PathVariable Long id, @RequestBody Compra compra) {
        Compra actualizada = compraService.actualizarCompra(id, compra);
        return actualizada != null ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }

    // Eliminar una compra
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = compraService.eliminarCompra(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}