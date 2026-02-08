package com.microservicios.usuarios.demo.infraestructure.out.persistence.entity;

import com.microservicios.usuarios.demo.domain.model.User;
import com.microservicios.usuarios.demo.infraestructure.out.persistence.entity.UserEntity;

public class UserMapper {

    public static User toDomain(UserEntity entity) {
        if (entity == null) return null;

        return User.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .role(RoleMapper.toDomain(entity.getRole()))
                .build();
    }

    public static UserEntity toEntity(User user) {
        if (user == null) return null;

        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setNombre(user.getNombre());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setRole(RoleMapper.toEntity(user.getRole()));
        return entity;
    }
}
