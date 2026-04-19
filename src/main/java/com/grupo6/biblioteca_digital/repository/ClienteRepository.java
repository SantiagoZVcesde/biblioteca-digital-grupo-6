package com.grupo6.biblioteca_digital.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo6.biblioteca_digital.model.entity.ClienteEntity;
import com.grupo6.biblioteca_digital.Enums.TipoIdentidad;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    //por si se quiere llamar al cliente por el numero de identidad (es totalmente opcional)
    Optional<ClienteEntity> findByTipoIdentidad(TipoIdentidad tipoIdentidad);
}
