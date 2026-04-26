package com.grupo6.biblioteca_digital.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo6.biblioteca_digital.model.entity.CategoriaEntity;
import com.grupo6.biblioteca_digital.service.CategoriaServices;

@RestController
@RequestMapping("/api/Categoria")
public class CategoriaController {
        private final CategoriaServices categoriaServices;

    public CategoriaController(CategoriaServices categoriaServices) {
        this.categoriaServices = categoriaServices;
    }

    @GetMapping
    public List<CategoriaEntity> listar() {
        return categoriaServices.listarCategorias();
    }

    @PostMapping
    public CategoriaEntity guardar(@RequestBody CategoriaEntity categoria) {
        return categoriaServices.guardarCategoria(categoria);
    }

}
