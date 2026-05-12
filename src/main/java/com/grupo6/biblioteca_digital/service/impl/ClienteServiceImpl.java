package com.grupo6.biblioteca_digital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo6.biblioteca_digital.model.dto.ClienteDTO;
import com.grupo6.biblioteca_digital.model.dto.ClienteRegistroDTO;
import com.grupo6.biblioteca_digital.model.embeddable.Contacto;
import com.grupo6.biblioteca_digital.model.entity.ClienteEntity;
import com.grupo6.biblioteca_digital.service.ClienteService;
import com.grupo6.biblioteca_digital.repository.ClienteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService { // Una sola 'l'

    @Autowired
    private ClienteRepository repository; // 'repository' en minúscula es mejor práctica

@Override
public ClienteDTO registrar(ClienteRegistroDTO dto) {
    // 1. Mapeamos manualmente para incluir los campos nuevos
    ClienteEntity entidad = new ClienteEntity();
    entidad.setNombre(dto.getNombre());
    entidad.setApellido(dto.getApellido());
    entidad.setTipoIdentidad(dto.getTipoIdentidad());
    entidad.setNumeroIdentidad(dto.getNumeroIdentidad());
    
    // Configurar contacto (como ya lo haces)
    Contacto con = new Contacto();
    con.setEmail(dto.getEmail());
    con.setTelefono(dto.getTelefono());
    con.setDireccion(dto.getDireccion());
    entidad.setContacto(con);

    // 2. AÑADIMOS LO NUEVO
    entidad.setPassword(dto.getPassword()); // La clave secreta
    entidad.setRol(dto.getRol());           // El poder (ADMIN/CLIENTE)

    // 3. Guardar en DB
    repository.save(entidad);
    
    return mapearDTO(entidad); // Devolvemos el DTO normal (SIN password)
}

@Override
    public ClienteDTO guardar(ClienteDTO dto) {
        ClienteEntity cliente = mapearEntidad(dto);
        repository.save(cliente);
        dto.setId(cliente.getId());
        return dto;
    }

    @Override
    public List<ClienteDTO> obtenerTodos() {
        return repository.findAll().stream()
                .map(this::mapearDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO obtenerPorId(Long id) {
        ClienteEntity cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " + id));
        return mapearDTO(cliente);
    }

    @Override
    public ClienteDTO actualizar(Long id, ClienteDTO dto) {
        ClienteEntity clienteExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se puede actualizar, id no encontrado: " + id));
        
        // Actualizamos los campos
        clienteExistente.setNombre(dto.getNombre());
        clienteExistente.setApellido(dto.getApellido());
        clienteExistente.setTipoIdentidad(dto.getTipoIdentidad());
        clienteExistente.setNumeroIdentidad(dto.getNumeroIdentidad());
        
        Contacto con = new Contacto();
        con.setEmail(dto.getEmail());
        con.setTelefono(dto.getTelefono());
        con.setDireccion(dto.getDireccion());
        clienteExistente.setContacto(con);

        repository.save(clienteExistente);
        return mapearDTO(clienteExistente);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar, id no existe: " + id);
        }
        repository.deleteById(id);
    }

    // --- MÉTODOS AUXILIARES DE MAPEO (Para no repetir código) ---

    private ClienteDTO mapearDTO(ClienteEntity entidad) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(entidad.getId());
        dto.setNombre(entidad.getNombre());
        dto.setApellido(entidad.getApellido());
        dto.setTipoIdentidad(entidad.getTipoIdentidad());
        dto.setNumeroIdentidad(entidad.getNumeroIdentidad());
        if (entidad.getContacto() != null) {
            dto.setEmail(entidad.getContacto().getEmail());
            dto.setTelefono(entidad.getContacto().getTelefono());
            dto.setDireccion(entidad.getContacto().getDireccion());
        }
        return dto;
    }

    private ClienteEntity mapearEntidad(ClienteDTO dto) {
        ClienteEntity entidad = new ClienteEntity();
        entidad.setNombre(dto.getNombre());
        entidad.setApellido(dto.getApellido());
        entidad.setTipoIdentidad(dto.getTipoIdentidad());
        entidad.setNumeroIdentidad(dto.getNumeroIdentidad());
        
        Contacto con = new Contacto();
        con.setEmail(dto.getEmail());
        con.setTelefono(dto.getTelefono());
        con.setDireccion(dto.getDireccion());
        entidad.setContacto(con);
        return entidad;
    }
}