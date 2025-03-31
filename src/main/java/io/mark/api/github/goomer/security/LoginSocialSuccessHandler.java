package io.mark.api.github.goomer.security;

import io.mark.api.github.goomer.dto.CreateUserDTO;
import io.mark.api.github.goomer.enums.Role;
import io.mark.api.github.goomer.mapper.UsuarioMapper;
import io.mark.api.github.goomer.model.Usuarios;
import io.mark.api.github.goomer.service.UsuarioService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class LoginSocialSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private static final String SENHA_PADRAO = "321";

    private final UsuarioService usuarioService;

    private final UsuarioMapper usuarioMapper;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {

        OAuth2AuthenticationToken auth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;
        OAuth2User oAuth2User = auth2AuthenticationToken.getPrincipal();

        String email = oAuth2User.getAttribute("email");

        Usuarios usuario = usuarioService.obterPorEmail(email);

        if(usuario == null){
            usuario = cadastrarUsuarioNaBase(email);
        }

        authentication = new CustomAuthentication(usuario);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        super.onAuthenticationSuccess(request, response, authentication);
    }

    private Usuarios cadastrarUsuarioNaBase(String email) {
        Usuarios usuario;
        usuario = new Usuarios();
        usuario.setEmail(email);

        usuario.setEmail(obterLoginApartirEmail(email));

        usuario.setSenha(SENHA_PADRAO);
        usuario.setRole(Role.valueOf("CLIENT"));

        CreateUserDTO usuarios = usuarioMapper.toDto(usuario);

        usuarioService.criarUsuario(usuarios);
        return usuario;
    }

    private String obterLoginApartirEmail(String email) {
        return email.substring(0, email.indexOf("@"));
    }
}