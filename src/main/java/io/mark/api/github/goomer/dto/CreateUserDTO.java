package io.mark.api.github.goomer.dto;

import io.mark.api.github.goomer.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record CreateUserDTO(
        @Email(message = "formato de email invalido")
        @NotNull(message = "O email não pode ser vázio")
        String email,
        @NotBlank(message = "A senha não pode ser vázia")
        @Length(min = 8, message = "A senha precisa ter no minimo 8 caracteres")
        String senha,
        Role role) {
}
