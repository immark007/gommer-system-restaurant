package io.mark.api.github.goomer.controller;

import io.mark.api.github.goomer.dto.CreateUserDTO;
import io.mark.api.github.goomer.model.Usuarios;
import io.mark.api.github.goomer.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuarios> create(@RequestBody @Valid CreateUserDTO createUserDTO) {
        usuarioService.criarUsuario(createUserDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
