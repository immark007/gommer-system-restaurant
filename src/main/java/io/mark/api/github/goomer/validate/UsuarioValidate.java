package io.mark.api.github.goomer.validate;

import io.mark.api.github.goomer.exceptions.AcessoNegadoException;
import io.mark.api.github.goomer.exceptions.UsuarioDuplicadoException;
import io.mark.api.github.goomer.exceptions.UsuarioNaoEncontradoException;
import io.mark.api.github.goomer.model.Usuarios;
import io.mark.api.github.goomer.repository.UsuarioRepository;
import io.mark.api.github.goomer.security.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UsuarioValidate {
    private final UsuarioRepository usuarioRepository;

    public void validateEmailUser(Usuarios usuario) {
        if (emailJaCadastrado(usuario)) {
            throw new UsuarioDuplicadoException("Esse usuário já existe");
        }
    }

    private boolean emailJaCadastrado(Usuarios usuario) {
        Usuarios usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());

        if (usuarioExistente == null) {
            return false;
        }

        return usuario.getId() == null || !usuario.getId().equals(usuarioExistente.getId());
    }
}
