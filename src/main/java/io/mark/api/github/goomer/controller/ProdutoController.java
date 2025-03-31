package io.mark.api.github.goomer.controller;

import io.mark.api.github.goomer.dto.ProdutoDTO;
import io.mark.api.github.goomer.mapper.ProdutoMapper;
import io.mark.api.github.goomer.model.Produtos;
import io.mark.api.github.goomer.model.Restaurante;
import io.mark.api.github.goomer.service.ProdutoService;
import io.mark.api.github.goomer.service.RestauranteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;
    private final RestauranteService restauranteService;

    public ProdutoController(ProdutoService produtoService, RestauranteService restauranteService) {
        this.produtoService = produtoService;
        this.restauranteService = restauranteService;
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        Produtos produto = ProdutoMapper.INSTANCE.toEntity(produtoDTO);

        // Buscar restaurante associado
        Restaurante restaurante = restauranteService.buscarPorId(produtoDTO.restauranteId());
        produto.setRestaurante(restaurante);

        Produtos produtoSalvo = produtoService.salvar(produto);
        return ResponseEntity.ok(ProdutoMapper.INSTANCE.toDTO(produtoSalvo));
    }
}