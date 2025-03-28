package io.mark.api.github.goomer.mapper;

import io.mark.api.github.goomer.dto.ProdutoDTO;
import io.mark.api.github.goomer.model.Produtos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {
    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    @Mapping(source = "restaurante.id", target = "restauranteId")
    ProdutoDTO toDTO(Produtos produto);

    @Mapping(source = "restauranteId", target = "restaurante.id")
    Produtos toEntity(ProdutoDTO dto);
}
