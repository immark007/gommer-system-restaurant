package io.mark.api.github.goomer.controller;

import io.mark.api.github.goomer.dto.CreateRestauranteDTO;
import io.mark.api.github.goomer.dto.UpdateRestauranteDTO;
import io.mark.api.github.goomer.mapper.RestauranteMapper;
import io.mark.api.github.goomer.model.Restaurante;
import io.mark.api.github.goomer.service.RestauranteService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    private final RestauranteService restauranteService;

    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @PostMapping
    public ResponseEntity<CreateRestauranteDTO> criarRestaurante(@RequestBody CreateRestauranteDTO restauranteDTO) {
        Restaurante restaurante = RestauranteMapper.INSTANCE.toEntity(restauranteDTO);
        Restaurante restauranteSalvo = restauranteService.salvar(restaurante);
        return ResponseEntity.ok(RestauranteMapper.INSTANCE.toDTO(restauranteSalvo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateRestauranteDTO> buscarRestaurante(@PathVariable UUID id) {
        Restaurante restaurante = restauranteService.buscarPorId(id);
        CreateRestauranteDTO restauranteDTO = RestauranteMapper.INSTANCE.toDTO(restaurante);
        return ResponseEntity.ok(restauranteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> atualizarRestaurante(
            @PathVariable UUID id,
            @RequestBody UpdateRestauranteDTO dto) {
        Restaurante atualizado = restauranteService.updateRestaurante(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<CreateRestauranteDTO>> search(
            @RequestParam(value = "nome", required = false) String nome,
            @RequestParam(value = "cidade", required = false) String cidade,
            @RequestParam(value = "horario", required = false) String horario,
            @RequestParam(value = "categoriaProduto", required = false) String categoriaProduto,
            @RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
            @RequestParam(value = "tamanhoPagina", defaultValue = "10") Integer tamanhoPagina
    ) {
        Page<Restaurante> paginaResultado = restauranteService.search(nome, cidade, horario, categoriaProduto, pagina, tamanhoPagina);

        Page<CreateRestauranteDTO> resultado = paginaResultado.map(RestauranteMapper.INSTANCE::toDTO);

        return ResponseEntity.ok(resultado);
    }
}
