package io.mark.api.github.goomer.security;

import io.mark.api.github.goomer.model.Usuarios;
import io.mark.api.github.goomer.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String password = authentication.getCredentials() != null ? authentication.getCredentials().toString() : null;

        if (password == null || password.isEmpty()) {
            System.out.println("Senha não fornecida");
            throw new UsernameNotFoundException("Senha não fornecida");
        }

        Usuarios usuarioEncontrado = usuarioService.obterPorEmail(login);

        if (usuarioEncontrado == null) {
            System.out.println("Usuário não encontrado: " + login);
            throw new UsernameNotFoundException("Usuário não encontrado");
        }


        if (!passwordEncoder.matches(password, usuarioEncontrado.getSenha())) {
            System.out.println("Senha incorreta para o usuário: " + login);
            throw new UsernameNotFoundException("Senha incorreta");
        }

        System.out.println("Autenticação bem-sucedida para o usuário: " + login);
        return new CustomAuthentication(usuarioEncontrado);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}
