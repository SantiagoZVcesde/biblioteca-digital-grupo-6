package com.grupo6.biblioteca_digital.service;

import com.grupo6.biblioteca_digital.model.entity.Compra;
import com.grupo6.biblioteca_digital.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    // Obtener todas las compras
    public List<Compra> listarCompras() {
        return compraRepository.findAll();
    }

    // Buscar una compra por su ID
    public Compra buscarPorId(Long id) {
        return compraRepository.findById(id).orElse(null);
    }

    // Registrar una nueva compra
    @Transactional
    public Compra registrarCompra(Compra compra) {
        // Aquí podrías luego sumar la 'cantidad' al stock global si fuera necesario
        return compraRepository.save(compra);
    }

    // Actualizar una compra existente
    @Transactional
    public Compra actualizarCompra(Long id, Compra detalles) {
        return compraRepository.findById(id).map(compra -> {
            compra.setProveedor(detalles.getProveedor());
            compra.setMonto(detalles.getMonto());
            compra.setCantidad(detalles.getCantidad());
            // Nota: No actualizamos 'fechaRegristro' para mantener el registro original
            return compraRepository.save(compra);
        }).orElse(null);
    }

    // Eliminar una compra
    @Transactional
    public boolean eliminarCompra(Long id) {
        return compraRepository.findById(id).map(compra -> {
            compraRepository.delete(compra);
            return true;
        }).orElse(false);
    }
}