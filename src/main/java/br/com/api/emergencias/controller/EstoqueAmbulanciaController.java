package br.com.api.emergencias.controller;

import br.com.api.emergencias.model.EstoqueAmbulancia;
import br.com.api.emergencias.service.IEstoqueAmbulanciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque-ambulancia")
@RequiredArgsConstructor
public class EstoqueAmbulanciaController {
    private final IEstoqueAmbulanciaService estoqueService;

    @PostMapping
    public ResponseEntity<EstoqueAmbulancia> cadastrarItem(
            @RequestBody EstoqueAmbulancia estoque) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(estoqueService.cadastrarItem(estoque));
    }
/*
    @PatchMapping("/{id}/ajuste")
    public ResponseEntity<Void> ajustarEstoque(
            @PathVariable Long id,
            @RequestParam Integer quantidade) {
        estoqueService.ajustarEstoque(id, quantidade);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/veiculo/{veiculoId}")
    public ResponseEntity<List<EstoqueAmbulancia>> listarPorVeiculo(
            @PathVariable Long veiculoId) {
        return ResponseEntity.ok(estoqueService.listarPorVeiculo(veiculoId));
    }

    @GetMapping("/baixo-estoque")
    public ResponseEntity<List<EstoqueAmbulancia>> listarItensBaixoEstoque() {
        return ResponseEntity.ok(estoqueService.listarItensBaixoEstoque());
    }

 */
}