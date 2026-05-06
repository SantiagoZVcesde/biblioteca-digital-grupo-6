package com.grupo6.biblioteca_digital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.grupo6.biblioteca_digital.model.dto.LibroDTO;
import com.grupo6.biblioteca_digital.model.entity.CategoriaEntity;
import com.grupo6.biblioteca_digital.model.entity.LibroEntity;
import com.grupo6.biblioteca_digital.repository.CategoriaRepository;
import com.grupo6.biblioteca_digital.repository.LibroRepository;

@Service
public class LibroServices {
    private final LibroRepository libroRepository;
    private final CategoriaRepository categoriaRepository;

    public LibroServices(LibroRepository libroRepository, CategoriaRepository categoriaRepository) {
        this.libroRepository = libroRepository;
        this.categoriaRepository = categoriaRepository;
    }

    // Listar todos los libros
    public List<LibroEntity> listarLibros() {
        return libroRepository.findAll();
    }


    // Buscar libro por ID
    public Optional<LibroEntity> buscarPorId(Long id) {
        return libroRepository.findById(id);
    }
    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }


public LibroEntity crearLibro(LibroEntity libro) {
    // Validar categoría
    CategoriaEntity categoria = categoriaRepository.findByNombre(libro.getCategoria().getNombre())
        .orElseGet(() -> {
            CategoriaEntity nuevaCategoria = new CategoriaEntity();
            nuevaCategoria.setNombre(libro.getCategoria().getNombre());
            nuevaCategoria.setDescripcion("Categoría creada automáticamente");
            return categoriaRepository.save(nuevaCategoria);
        });

    libro.setCategoria(categoria);

    // Validar por título (evitar duplicados)
    Optional<LibroEntity> existente = libroRepository.findByTitulo(libro.getTitulo());

    if (existente.isPresent()) {
        LibroEntity libroExistente = existente.get();
        libroExistente.setCantidad(libroExistente.getCantidad() + libro.getCantidad());
        libroExistente.actualizarDisponibilidad();
        return libroRepository.save(libroExistente);
    }

    // Si no existe, crear nuevo
    libro.actualizarDisponibilidad();
    return libroRepository.save(libro);  // ✅ Único return
}

    private LibroDTO toDTO(LibroEntity entity) {
    LibroDTO dto = new LibroDTO();
    dto.setId(entity.getId());
    dto.setTitulo(entity.getTitulo());
    dto.setPrecio(entity.getPrecio());
    return dto;
    }

        private LibroEntity toEntity(LibroDTO dto, CategoriaEntity categoria) {
        LibroEntity entity = new LibroEntity();
        entity.setTitulo(dto.getTitulo());
        entity.setCantidad(dto.getCantidad());
        entity.setCategoria(categoria);
        return entity;
    

    }

        public List<LibroDTO> listarLibrosDTO() {
        return libroRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }
        // Guardar libro usando DTO
    public LibroDTO guardarLibroDTO(LibroDTO libroDTO) {
        // Buscar categoría por nombre
        Optional<CategoriaEntity> categoriaOpt = categoriaRepository.findByNombre(libroDTO.getCategoria());
    
        // Si no existe, crear nueva
        CategoriaEntity categoria = categoriaOpt.orElseGet(() -> {
            CategoriaEntity nuevaCategoria = new CategoriaEntity();
            nuevaCategoria.setNombre(libroDTO.getCategoria()); 
            nuevaCategoria.setDescripcion("Categoría creada automáticamente");
            return categoriaRepository.save(nuevaCategoria);
        });
    
        // Validar si ya existe un libro con el mismo título
        Optional<LibroEntity> existente = libroRepository.findByTitulo(libroDTO.getTitulo());
        if (existente.isPresent()) {
            LibroEntity libroExistente = existente.get();
            libroExistente.setCantidad(libroExistente.getCantidad() + libroDTO.getCantidad());
            libroRepository.save(libroExistente);
            return toDTO(libroExistente);
        }
    
        // Crear nuevo libro
        LibroEntity nuevo = toEntity(libroDTO, categoria);
        libroRepository.save(nuevo);
        return toDTO(nuevo);
    }
}

