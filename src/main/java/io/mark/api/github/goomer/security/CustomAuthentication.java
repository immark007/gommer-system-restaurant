package io.mark.api.github.goomer.security;

import io.mark.api.github.goomer.model.Usuarios;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;

@RequiredArgsConstructor
@Getter
public class CustomAuthentication implements Authentication {
    private final Usuarios usuarios;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(this.usuarios.getRole().toString()));
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return usuarios;
    }

    @Override
    public Object getPrincipal() {
        return usuarios;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return usuarios.getEmail();
    }
}
