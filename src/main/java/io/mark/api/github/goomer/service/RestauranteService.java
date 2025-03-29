package io.mark.api.github.goomer.service;


import io.mark.api.github.goomer.dto.UpdateRestauranteDTO;
import io.mark.api.github.goomer.exceptions.RestauranteNaoEncontradoException;
import io.mark.api.github.goomer.mapper.RestauranteMapper;
import io.mark.api.github.goomer.model.Restaurante;
import io.mark.api.github.goomer.model.Usuarios;
import io.mark.api.github.goomer.repository.RestauranteRepository;
import io.mark.api.github.goomer.security.SecurityService;
import io.mark.api.github.goomer.validate.RestauranteValidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import static io.mark.api.github.goomer.repository.specs.RestauranteSpecs.*;

import java.util.UUID;

import static io.mark.api.github.goomer.repository.specs.RestauranteSpecs.*;
import static io.mark.api.github.goomer.repository.specs.RestauranteSpecs.produtoCategoriaLike;

@Service
public class RestauranteService {

    private final RestauranteRepository restauranteRepository;
    private final RestauranteMapper restauranteMapper;
    private final RestauranteValidate restauranteValidate;
    private final SecurityService securityService;

    public RestauranteService(RestauranteRepository restauranteRepository, RestauranteMapper restauranteMapper, RestauranteValidate restauranteValidate, SecurityService securityService) {
        this.restauranteRepository = restauranteRepository;
        this.restauranteMapper = restauranteMapper;
        this.restauranteValidate = restauranteValidate;
        this.securityService = securityService;
    }

    public Restaurante salvar(Restaurante restaurante) {
        restauranteValidate.validate(restaurante);
        Usuarios usuario = securityService.autenticar();
        restaurante.setUsuario(usuario);
        return restauranteRepository.save(restaurante);
    }

    public Restaurante buscarPorId(UUID id) {
        return restauranteRepository.findById(id)
                .orElseThrow(() -> new RestauranteNaoEncontradoException("Restaurante não encontrado"));
    }

    public void removeRestaurante(UUID id) {
        buscarPorId(id);
        restauranteRepository.deleteById(id);
    }


    public Restaurante updateRestaurante(UUID id, UpdateRestauranteDTO dto) {

        Restaurante restaurante = restauranteValidate.validarPermissao(id);

        restauranteMapper.updateRestauranteFromDto(dto, restaurante);
        return restauranteRepository.save(restaurante);
    }

    public void deletarRestaurante(UUID id) {
        Restaurante restaurante = restauranteValidate.validarPermissao(id);
        restauranteRepository.deleteById(id);
    }

    public Page<Restaurante> search(String nome, String cidade, String horario, String categoriaProduto, Integer pagina, Integer tamanhoPagina){
        Specification<Restaurante> specification = Specification.where(((root, query, criteriaBuilder) -> criteriaBuilder.conjunction()));


        if(nome != null){
            specification = specification.and(nameLike(nome));
        }

        if(cidade != null){
            specification = specification.and(cidadeEquals(cidade));
        }

        if(horario != null){
            specification = specification.and(horarioFuncionamentoLike(horario));
        }

        if(categoriaProduto != null){
            specification = specification.and(produtoCategoriaLike(categoriaProduto));
        }

        Pageable pageable = PageRequest.of(pagina,tamanhoPagina);

        return restauranteRepository.findAll(specification, pageable);
    }


}
