package com.grupo6.biblioteca_digital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.grupo6.biblioteca_digital.model.dto.ClienteDTO;

@Service
public interface ClienteService {
    ClienteDTO guardar(ClienteDTO dto);
    List<ClienteDTO> obtenerTodos();
    //Nuevos metodos de la actualizacion
    ClienteDTO obtenerPorId(Long id);
    ClienteDTO actualizar(Long id, ClienteDTO dto);
    void eliminar(Long id);
}
