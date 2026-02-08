package com.microservicios.usuarios.demo.infraestructure.out.persistence.entity;

import com.microservicios.usuarios.demo.domain.model.Roles;
import com.microservicios.usuarios.demo.infraestructure.out.persistence.entity.RoleEntity;

public class RoleMapper {

    public static Roles toDomain(RoleEntity entity) {
        if (entity == null) return null;

        return Roles.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .build();
    }

    public static RoleEntity toEntity(Roles role) {
        if (role == null) return null;

        RoleEntity entity = new RoleEntity();
        entity.setId(role.getId());
        entity.setNombre(role.getNombre());
        return entity;
    }
}
