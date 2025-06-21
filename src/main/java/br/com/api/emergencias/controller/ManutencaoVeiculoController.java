package br.com.api.emergencias.controller;

import br.com.api.emergencias.model.ManutencaoVeiculo;
import br.com.api.emergencias.service.IManutencaoVeiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manutencoes-veiculos")
@RequiredArgsConstructor
public class ManutencaoVeiculoController {
    private final IManutencaoVeiculoService manutencaoService;

    @PostMapping
    public ResponseEntity<ManutencaoVeiculo> agendarManutencao(
            @RequestBody ManutencaoVeiculo manutencao) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(manutencaoService.agendarManutencao(manutencao));
    }
/*
    @PatchMapping("/{id}/status")
    public ResponseEntity<ManutencaoVeiculo> atualizarStatus(
            @PathVariable Long id,
            @RequestParam StatusManutencao status) {
        return ResponseEntity.ok(manutencaoService.atualizarStatus(id, status));
    }

    @GetMapping("/veiculo/{veiculoId}")
    public ResponseEntity<List<ManutencaoVeiculo>> listarPorVeiculo(
            @PathVariable Long veiculoId) {
        return ResponseEntity.ok(manutencaoService.listarPorVeiculo(veiculoId));
    }

    @GetMapping("/atrasadas")
    public ResponseEntity<List<ManutencaoVeiculo>> listarAtrasadas() {
        return ResponseEntity.ok(manutencaoService.listarManutencoesAtrasadas());
    }

 */
}