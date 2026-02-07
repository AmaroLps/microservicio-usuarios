package com.microservicios.usuarios.demo.infraestructure.out.persistence.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Long id;
    private String nombre;
    private String email;
    private String password;
    private Roles role;  // La clase Roles de tu dominio
}
