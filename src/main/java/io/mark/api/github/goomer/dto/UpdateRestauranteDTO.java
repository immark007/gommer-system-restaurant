package io.mark.api.github.goomer.dto;

import java.util.List;
import java.util.UUID;

public record UpdateRestauranteDTO (
        String fotoURL,
        String nome,
        EnderecoDTO endereco,
        String horarioFuncionamento,
        UUID usuarioId,
        List<ProdutoDTO> produtos
){

}
