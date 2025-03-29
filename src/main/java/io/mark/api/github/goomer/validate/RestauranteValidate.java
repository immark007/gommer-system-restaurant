package io.mark.api.github.goomer.validate;

import io.mark.api.github.goomer.exceptions.AcessoNegadoException;
import io.mark.api.github.goomer.exceptions.RestauranteDuplicadoException;
import io.mark.api.github.goomer.model.Restaurante;
import io.mark.api.github.goomer.model.Usuarios;
import io.mark.api.github.goomer.repository.RestauranteRepository;
import io.mark.api.github.goomer.security.SecurityService;
import io.mark.api.github.goomer.service.RestauranteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RestauranteValidate {

    private final RestauranteRepository restauranteRepository;
    private final SecurityService securityService;
    private final RestauranteService restauranteService;

    public RestauranteValidate(RestauranteRepository restauranteRepository, SecurityService securityService, RestauranteService restauranteService) {
        this.restauranteRepository = restauranteRepository;
        this.securityService = securityService;
        this.restauranteService = restauranteService;
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


    public Restaurante validarPermissao(UUID id) {
        Restaurante restauranteExistente = restauranteService.buscarPorId(id);
        Usuarios usuarioAutenticado = securityService.autenticar();

        if (!restauranteExistente.getUsuario().getId().equals(usuarioAutenticado.getId())) {
            throw new AcessoNegadoException("Você não tem permissão para gerenciar este restaurante");
        }

        return restauranteExistente;
    }
}
