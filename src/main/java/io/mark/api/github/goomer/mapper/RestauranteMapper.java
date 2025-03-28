package io.mark.api.github.goomer.mapper;

import io.mark.api.github.goomer.dto.CreateRestauranteDTO;
import io.mark.api.github.goomer.dto.UpdateRestauranteDTO;
import io.mark.api.github.goomer.model.Restaurante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RestauranteMapper {
    RestauranteMapper INSTANCE = Mappers.getMapper(RestauranteMapper.class);

    @Mapping(source = "usuario.id", target = "usuarioId")
    @Mapping(source = "endereco", target = "endereco") // Adicionando o mapeamento do Endereco
    CreateRestauranteDTO toDTO(Restaurante restaurante);

    @Mapping(source = "usuarioId", target = "usuario.id")
    @Mapping(source = "endereco", target = "endereco") // Adicionando o mapeamento do Endereco
    Restaurante toEntity(CreateRestauranteDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuario.id", source = "usuarioId", ignore = true)
    @Mapping(source = "endereco", target = "endereco") // Adicionando o mapeamento do Endereco
    void updateRestauranteFromDto(UpdateRestauranteDTO dto, @MappingTarget Restaurante restaurante);
}
