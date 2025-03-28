package io.mark.api.github.goomer.service;

import io.mark.api.github.goomer.controller.GenericController;
import io.mark.api.github.goomer.dto.CreateUserDTO;
import io.mark.api.github.goomer.mapper.UsuarioMapper;
import io.mark.api.github.goomer.model.Usuarios;
import io.mark.api.github.goomer.repository.UsuarioRepository;
import io.mark.api.github.goomer.validate.UsuarioValidate;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import static io.mark.api.github.goomer.repository.specs.RestauranteSpecs.*;

@Service
@RequiredArgsConstructor
public class UsuarioService implements GenericController {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final UsuarioValidate usuarioValidate;
    private final PasswordEncoder passwordEncoder;

    public Usuarios criarUsuario(CreateUserDTO createUserDTO) {
        Usuarios usuarios = usuarioMapper.toEntity(createUserDTO);
        String senhaCriptografada = passwordEncoder.encode(usuarios.getSenha());
        usuarioValidate.validateEmailUser(usuarios);
        usuarios.setSenha(senhaCriptografada);
        return usuarioRepository.save(usuarios);
    }

    public Usuarios deleteUsuario(UUID id) {
        getUsuario(id).ifPresent(usuarioRepository::delete);
        return usuarioRepository.findById(id).orElse(null);
    }

    public Optional<Usuarios> getUsuario(UUID id) {
        return usuarioRepository.findById(id);
    }

    public Usuarios obterPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
