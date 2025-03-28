package io.mark.api.github.goomer.validate;

import io.mark.api.github.goomer.exceptions.RestauranteDuplicadoException;
import io.mark.api.github.goomer.model.Restaurante;
import io.mark.api.github.goomer.repository.RestauranteRepository;
import org.springframework.stereotype.Component;

@Component
public class RestauranteValidate {

    private final RestauranteRepository restauranteRepository;

    public RestauranteValidate(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public void validate(Restaurante restaurante) {
        if (validateEndereco(restaurante)) {
            throw new RestauranteDuplicadoException("Já existe um restaurante cadastrado nesse endereço.");
        }
    }

    private boolean validateEndereco(Restaurante restaurante) {
        return restauranteRepository.existsByEndereco_RuaAndEndereco_NumeroAndEndereco_Cidade(
                restaurante.getEndereco().getRua(),
                restaurante.getEndereco().getNumero(),
                restaurante.getEndereco().getCidade()
        );
    }
}
