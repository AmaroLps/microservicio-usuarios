package com.microservicios.usuarios.demo.domain.ports.in.dto;

import com.microservicios.usuarios.demo.domain.model.Roles;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private Long id;
    private String nombre;
    private String email;
    private Roles role; // Para mostrar el rol del usuario
}
