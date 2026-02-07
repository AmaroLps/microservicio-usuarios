package com.microservicios.usuarios.demo.infraestructure.out.persistence.repository;

import com.microservicios.usuarios.demo.domain.model.Roles;
import com.microservicios.usuarios.demo.domain.ports.out.RoleRepository;
import com.microservicios.usuarios.demo.infraestructure.out.persistence.entity.RoleEntity;
import com.microservicios.usuarios.demo.infraestructure.out.persistence.repository.RoleJpaRepository;
import com.microservicios.usuarios.demo.infraestructure.out.persistence.entity.RoleMapper;  // Debes tener este mapper también

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RoleRepositoryAdapter implements RoleRepository {

    private final RoleJpaRepository jpaRepository;

    @Override
    public Roles save(Roles role) {
        RoleEntity entity = RoleMapper.toEntity(role);
        RoleEntity savedEntity = jpaRepository.save(entity);
        return RoleMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Roles> findById(Long id) {
        return jpaRepository.findById(id)
                .map(RoleMapper::toDomain);
    }

    @Override
    public Optional<Roles> findByNombre(String nombre) {
        return jpaRepository.findByNombre(nombre)
                .map(RoleMapper::toDomain);
    }
}