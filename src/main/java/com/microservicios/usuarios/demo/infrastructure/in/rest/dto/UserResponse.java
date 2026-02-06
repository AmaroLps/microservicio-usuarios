package com.microservicios.usuarios.demo.infrastructure.in.rest.dto;
import com.microservicios.usuarios.demo.domain.model.Roles;
import lombok.Builder;
import lombok.Data;

@Data @Builder
public class UserResponse {
    private Long id;
    private String nombre;
    private String email;
    private Roles role; // Agregado para ver el rol en la respuesta
}