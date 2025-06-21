package br.com.api.emergencias.controller;

import br.com.api.emergencias.model.ServicoManutencao;
import br.com.api.emergencias.repository.ManutencaoVeiculoRepository;
import br.com.api.emergencias.service.IServicoManutencaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/manutencoes/{manutencaoId}/servicos")
@RequiredArgsConstructor
public class ServicoManutencaoController {

    private final IServicoManutencaoService servicoService;
    private final ManutencaoVeiculoRepository manutencaoRepository;

    @PostMapping
    public ResponseEntity<ServicoManutencao> adicionarServico(
            @PathVariable Long manutencaoId,
            @RequestBody ServicoManutencao servico) {

        // Vincula o serviço à manutenção correta
        servico.setManutencao(
                manutencaoRepository.findById(manutencaoId)
                        .orElseThrow(() -> new RuntimeException("Manutenção não encontrada"))
        );

        // Salva o serviço
        ServicoManutencao servicoSalvo = servicoService.adicionarServico(servico);

        return ResponseEntity.status(HttpStatus.CREATED).body(servicoSalvo);
    }
}
/*
    @GetMapping
    public ResponseEntity<List<ServicoManutencao>> listarServicos(
            @PathVariable Long manutencaoId) {
        return ResponseEntity.ok(servicoService.listarServicosPorManutencao(manutencaoId));
    }

    @GetMapping("/total")
    public ResponseEntity<BigDecimal> calcularTotal(
            @PathVariable Long manutencaoId) {
        return ResponseEntity.ok(servicoService.calcularTotalServicos(manutencaoId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerServico(
            @PathVariable Long manutencaoId,
            @PathVariable Long id) {
        servicoService.removerServico(id);

        // Atualiza o custo total da manutenção
        BigDecimal novoTotal = servicoService.calcularTotalServicos(manutencaoId);
        manutencaoService.atualizarCustoTotal(manutencaoId, novoTotal);

        return ResponseEntity.noContent().build();
    }

 }

*/