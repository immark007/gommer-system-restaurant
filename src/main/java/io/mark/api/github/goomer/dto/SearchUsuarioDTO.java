package io.mark.api.github.goomer.dto;

import io.mark.api.github.goomer.enums.Role;

public record SearchUsuarioDTO(String email, Role role) {
}
