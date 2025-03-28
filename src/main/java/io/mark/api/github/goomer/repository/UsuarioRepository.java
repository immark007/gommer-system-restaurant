package io.mark.api.github.goomer.repository;

import io.mark.api.github.goomer.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuarios, UUID> {
    Usuarios findByEmail(String email);
}
