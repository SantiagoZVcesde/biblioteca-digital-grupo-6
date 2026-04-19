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

    @GetMapping
    public List<Compra> listar() {
        return compraService.listarCompras();
    }

    @PostMapping
    public ResponseEntity<Compra> guardar(@RequestBody Compra compra) {
        return ResponseEntity.ok(compraService.registrarCompra(compra));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> obtenerUno(@PathVariable Long id) {
        Compra compra = compraService.buscarPorId(id);
        return compra != null ? ResponseEntity.ok(compra) : ResponseEntity.notFound().build();
    }
}