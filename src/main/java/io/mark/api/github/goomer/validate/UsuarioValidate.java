package io.mark.api.github.goomer.validate;

import io.mark.api.github.goomer.exceptions.UsuarioDuplicadoException;
import io.mark.api.github.goomer.model.Usuarios;
import io.mark.api.github.goomer.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsuarioValidate {
    private final UsuarioRepository usuarioRepository;

    public void validateEmailUser(Usuarios usuario) {
        if(validateEmail(usuario)){
            throw new UsuarioDuplicadoException("Esse usuario ja existe");
        }
    }

    public boolean validateEmail(Usuarios usuario) {
        Optional<Usuarios> usuarioOptional = usuarioRepository.findByEmail(usuario.getEmail());

        if(usuario.getId() == null){
            return usuarioOptional.isPresent();
        }

        return usuario.getId().equals(usuarioOptional.get().getId()) && usuarioOptional.isPresent();
    }
}
