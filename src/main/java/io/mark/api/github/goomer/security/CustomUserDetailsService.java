package io.mark.api.github.goomer.security;

import io.mark.api.github.goomer.model.Usuarios;
import io.mark.api.github.goomer.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomUserDetailsService implements UserDetailsService {
    private final UsuarioService usuarioService;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuarios usuario = usuarioService.obterPorEmail(email);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario não encontrado");
        }

        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getSenha())
                .roles(String.valueOf(usuario.getRole()))
                .build();
    }



}
