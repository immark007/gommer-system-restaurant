package io.mark.api.github.goomer.dto;

public record EnderecoDTO(
        String rua,
        String numero,
        String cidade,
        String estado,
        String cep
) {
}
