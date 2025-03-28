package io.mark.api.github.goomer.mapper;

import io.mark.api.github.goomer.dto.EnderecoDTO;
import io.mark.api.github.goomer.model.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {
    EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

    EnderecoDTO toDTO(Endereco endereco);

    Endereco toEntity(EnderecoDTO enderecoDTO);
}