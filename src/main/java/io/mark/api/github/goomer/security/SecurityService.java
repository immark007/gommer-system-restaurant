package io.mark.api.github.goomer.security;

import io.mark.api.github.goomer.model.Usuarios;
import io.mark.api.github.goomer.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecurityService {

    private final UsuarioService usuarioService;

    public Usuarios autenticar(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication instanceof CustomAuthentication customAuth){
            return customAuth.getUsuarios();
        }

        return null;
    }
}
