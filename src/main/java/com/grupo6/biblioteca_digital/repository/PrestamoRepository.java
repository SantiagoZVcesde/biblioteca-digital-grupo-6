package com.grupo6.biblioteca_digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo6.biblioteca_digital.model.entity.PrestamosEntity;

@Repository
public interface PrestamoRepository extends JpaRepository<PrestamosEntity, Long> {
    
}
