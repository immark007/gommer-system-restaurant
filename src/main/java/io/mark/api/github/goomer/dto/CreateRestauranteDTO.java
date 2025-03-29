package io.mark.api.github.goomer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record CreateRestauranteDTO(
        UUID id,
        @NotBlank(message = "O campo não pode ser vázio")
        String fotoURL,
        @NotBlank(message = "O campo não pode ser vázio")
        String nome,
        @NotNull(message = "O campo não pode ser nullo")
        EnderecoDTO endereco,
        @NotBlank(message = "O campo não pode ser vázio")
        String horarioFuncionamento,
        List<ProdutoDTO> produtos
) {
}
