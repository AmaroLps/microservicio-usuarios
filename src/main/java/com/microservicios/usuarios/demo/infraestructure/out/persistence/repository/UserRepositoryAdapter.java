package com.microservicios.usuarios.demo.infraestructure.out.persistence.repository;

import com.microservicios.usuarios.demo.domain.model.User;
import com.microservicios.usuarios.demo.domain.ports.out.UserRepository;
import com.microservicios.usuarios.demo.infraestructure.out.persistence.entity.UserEntity;
import com.microservicios.usuarios.demo.infraestructure.out.persistence.entity.UserMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository jpaRepository;

    @Override
    public User save(User user) {
        UserEntity entity = UserMapper.toEntity(user);
        UserEntity savedEntity = jpaRepository.save(entity);
        return UserMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaRepository.findById(id)
                .map(UserMapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaRepository.findByEmail(email)
                .map(UserMapper::toDomain);
    }
}
