package io.mark.api.github.goomer.controller;

import io.mark.api.github.goomer.dto.CreateUserDTO;
import io.mark.api.github.goomer.mapper.UsuarioMapper;
import io.mark.api.github.goomer.model.Usuarios;
import io.mark.api.github.goomer.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsuarioController implements GenericController{
    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    @PostMapping
    public ResponseEntity<Usuarios> create(@RequestBody @Valid CreateUserDTO createUserDTO) {
        Usuarios usuarios = new Usuarios();
        usuarios = usuarioService.criarUsuario(createUserDTO);
        URI location = gerarHeaderLocation(usuarios.getId());
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Usuarios usuarios) {
        usuarioService.deleteUsuario(usuarios.getId());

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") UUID id) {
       var usuario = usuarioService.getUsuario(id);
       return ResponseEntity.ok(usuario);
    }

}
