package io.mark.api.github.goomer.repository;

import io.mark.api.github.goomer.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produtos, UUID> {
}
