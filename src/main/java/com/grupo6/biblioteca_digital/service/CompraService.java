package com.grupo6.biblioteca_digital.service;

import com.grupo6.biblioteca_digital.model.dto.CompraCreateDTO;
import com.grupo6.biblioteca_digital.model.dto.CompraDTO;
import com.grupo6.biblioteca_digital.model.entity.Compra;
import com.grupo6.biblioteca_digital.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    // Obtener todas las compras (Retorna lista de DTOs)
    public List<CompraDTO> listarCompras() {
        return compraRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Buscar una compra por su ID (Retorna DTO o null)
    public CompraDTO buscarPorId(Long id) {
        return compraRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    // Registrar una nueva compra (Recibe CreateDTO y retorna DTO)
    @Transactional
    public CompraDTO registrarCompra(CompraCreateDTO dto) {
        Compra compra = toEntity(dto);
        // Aquí podrías luego sumar la 'cantidad' al stock global si fuera necesario
        Compra compraGuardada = compraRepository.save(compra);
        return toDTO(compraGuardada);
    }

    // Actualizar una compra existente (Recibe id, CreateDTO y retorna DTO)
    @Transactional
    public CompraDTO actualizarCompra(Long id, CompraCreateDTO detallesDto) {
        return compraRepository.findById(id).map(compra -> {
            compra.setProveedor(detallesDto.proveedor());
            compra.setMonto(detallesDto.monto());
            compra.setCantidad(detallesDto.cantidad());
            // Nota: No actualizamos 'fechaRegistro' para mantener el registro original
            Compra compraActualizada = compraRepository.save(compra);
            return toDTO(compraActualizada);
        }).orElse(null);
    }

    // Eliminar una compra (Se mantiene igual ya que usa el ID)
    @Transactional
    public boolean eliminarCompra(Long id) {
        return compraRepository.findById(id).map(compra -> {
            compraRepository.delete(compra);
            return true;
        }).orElse(false);
    }

    // --- MÉTODOS DE MAPEO MANUAL ---

    // Convierte de DTO de creación a Entidad
    private Compra toEntity(CompraCreateDTO dto) {
        Compra compra = new Compra();
        compra.setProveedor(dto.proveedor());
        compra.setMonto(dto.monto());
        compra.setCantidad(dto.cantidad());
        return compra;
    }

    // Convierte de Entidad a DTO de respuesta
    private CompraDTO toDTO(Compra entidad) {
        return new CompraDTO(
            entidad.getId(),
            entidad.getProveedor(),
            entidad.getMonto(),
            entidad.getCantidad(),
            entidad.getFechaRegistro()
        );
    }
}