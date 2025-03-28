package io.mark.api.github.goomer.service;

import io.mark.api.github.goomer.model.Produtos;
import io.mark.api.github.goomer.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produtos salvar(Produtos produto) {
        return produtoRepository.save(produto);
    }
}
