package io.mark.api.github.goomer.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutoDTO(
        UUID id,
        @NotBlank(message = "O campo não pode ser nullo")
        String fotoURL,
        @NotBlank(message = "o campo não pode ser nullo")
        String nome,
        BigDecimal preco,
        String categoria,
        UUID restauranteId
) {
}
