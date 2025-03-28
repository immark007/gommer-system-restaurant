package io.mark.api.github.goomer.repository;

import io.mark.api.github.goomer.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface RestauranteRepository extends JpaRepository<Restaurante, UUID>, JpaSpecificationExecutor<Restaurante> {
    boolean existsByEndereco_RuaAndEndereco_NumeroAndEndereco_Cidade(String rua, String numero, String cidade);
}
