package com.grupo6.biblioteca_digital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.grupo6.biblioteca_digital.model.entity.CategoriaEntity;
import com.grupo6.biblioteca_digital.repository.CategoriaRepository;

@Service
public class CategoriaServices {
        private final CategoriaRepository categoriaRepository;

    public CategoriaServices(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaEntity> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public CategoriaEntity guardarCategoria(CategoriaEntity categoria) {
        return categoriaRepository.save(categoria);
    }

}
