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

    @Mapping(source = "endereco", target = "endereco") // Mantém o mapeamento do endereço
    CreateRestauranteDTO toDTO(Restaurante restaurante);

    @Mapping(source = "endereco", target = "endereco") // Mantém o mapeamento do endereço
    Restaurante toEntity(CreateRestauranteDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "endereco", target = "endereco") // Mantém o mapeamento do endereço
    void updateRestauranteFromDto(UpdateRestauranteDTO dto, @MappingTarget Restaurante restaurante);
}

