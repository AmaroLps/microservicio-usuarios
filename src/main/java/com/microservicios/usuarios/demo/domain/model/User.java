package com.microservicios.usuarios.demo.domain.model;



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
    private Roles role; // Asegúrate que Roles también está definido en domain.model
}
