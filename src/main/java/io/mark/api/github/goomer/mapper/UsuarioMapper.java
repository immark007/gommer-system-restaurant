package io.mark.api.github.goomer.mapper;

import io.mark.api.github.goomer.dto.CreateUserDTO;
import io.mark.api.github.goomer.model.Usuarios;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuarios toEntity(CreateUserDTO createUserDTO);
    CreateUserDTO toDto(Usuarios usuarios);
}
