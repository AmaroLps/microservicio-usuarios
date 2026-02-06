package com.microservicios.usuarios.demo.domain.model;
import lombok.*;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class User {
    private Long id;
    private String nombre;
    private String email;
    private String password;
    private Roles role;
}