package com.microservicios.usuarios.demo.domain.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nombre;  // El nombre del rol, por ejemplo: "USER", "ADMIN"

    // Puedes agregar más campos si tu proyecto los necesita
}

