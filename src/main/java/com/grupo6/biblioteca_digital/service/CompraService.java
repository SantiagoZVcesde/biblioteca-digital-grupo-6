package com.grupo6.biblioteca_digital.service;

import com.grupo6.biblioteca_digital.model.entity.Compra;
import com.grupo6.biblioteca_digital.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    public List<Compra> listarCompras() {
        return compraRepository.findAll();
    }

    public Compra registrarCompra(Compra compra) {
        // Aquí podrías luego sumar la 'cantidad' al stock global si fuera necesario
        return compraRepository.save(compra);
    }

    public Compra buscarPorId(Long id) {
        return compraRepository.findById(id).orElse(null);
    }
}