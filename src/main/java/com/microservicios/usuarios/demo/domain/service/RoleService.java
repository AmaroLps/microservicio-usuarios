package com.microservicios.usuarios.demo.domain.service;

import com.microservicios.usuarios.demo.domain.model.Permissions;
import com.microservicios.usuarios.demo.domain.model.Roles;
import com.microservicios.usuarios.demo.domain.ports.out.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Roles crearRol(String nombre, List<String> permisosNombres) {
        List<Permissions> listaPermisos = permisosNombres.stream()
                .map(nombrePermiso -> Permissions.builder().nombre(nombrePermiso).build())
                .collect(Collectors.toList());

        Roles nuevoRol = Roles.builder()
                .nombre(nombre)
                .permisos(listaPermisos)
                .build();
        return roleRepository.save(nuevoRol);
    }

    public Optional<Roles> obtenerRolPorId(Long id) {
        return roleRepository.findById(id);
    }
}