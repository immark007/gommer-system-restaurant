package io.mark.api.github.goomer.repository.specs;

import io.mark.api.github.goomer.model.Restaurante;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public class RestauranteSpecs {

    public static Specification<Restaurante> nameLike(String nome) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")), "%" + nome.toLowerCase() + "%");
    }

    public static Specification<Restaurante> cidadeEquals(String cidade) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(criteriaBuilder.lower(root.get("endereco").get("cidade")), cidade.toLowerCase());
    }

    public static Specification<Restaurante> horarioFuncionamentoLike(String horario) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("horarioFuncionamento")), "%" + horario.toLowerCase() + "%");
    }

    public static Specification<Restaurante> usuarioIdEquals(UUID usuarioId) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("usuario").get("id"), usuarioId);
    }

    public static Specification<Restaurante> produtoCategoriaLike(String categoria) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.join("produtos").get("categoria")), "%" + categoria.toLowerCase() + "%");
    }
}
