package com.grupo6.biblioteca_digital.repository;

import com.grupo6.biblioteca_digital.model.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
    
}