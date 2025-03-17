package io.mark.api.github.goomer.service;

import io.mark.api.github.goomer.dto.CreateUserDTO;
import io.mark.api.github.goomer.mapper.UsuarioMapper;
import io.mark.api.github.goomer.model.Usuarios;
import io.mark.api.github.goomer.repository.UsuarioRepository;
import io.mark.api.github.goomer.validate.UsuarioValidate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final UsuarioValidate usuarioValidate;

    public Usuarios criarUsuario(CreateUserDTO createUserDTO) {
        Usuarios usuarios = usuarioMapper.toEntity(createUserDTO);
        usuarioValidate.validateEmailUser(usuarios);
        return usuarioRepository.save(usuarios);
    }
}
