package io.mark.api.github.goomer.mapper;

import io.mark.api.github.goomer.dto.CreateUserDTO;
import io.mark.api.github.goomer.dto.SearchUsuarioDTO;
import io.mark.api.github.goomer.model.Usuarios;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuarios toEntity(CreateUserDTO createUserDTO);
    CreateUserDTO toDto(Usuarios usuarios);

    Usuarios toSearchEntity(SearchUsuarioDTO searchUsuarioDTO);
    SearchUsuarioDTO toSearchDto(Optional<Usuarios> usuarios);
}
