package br.com.api.emergencias.service.impl;

import br.com.api.emergencias.model.ManutencaoVeiculo;
import br.com.api.emergencias.repository.ManutencaoVeiculoRepository;
import br.com.api.emergencias.repository.VeiculoRepository;
import br.com.api.emergencias.service.IManutencaoVeiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ManutencaoVeiculoService implements IManutencaoVeiculoService {
    private final ManutencaoVeiculoRepository manutencaoRepository;
    private final VeiculoRepository veiculoRepository;

    @Override
    public ManutencaoVeiculo agendarManutencao(ManutencaoVeiculo manutencao) {
        veiculoRepository.findById(manutencao.getVeiculo().getId())
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        if (manutencao.getDataServico().isBefore(LocalDate.now())) {
            throw new RuntimeException("Data de serviço não pode ser no passado");
        }

        return manutencaoRepository.save(manutencao);
    }
/*
    @Override
    public List<ManutencaoVeiculo> listarManutencoesAtrasadas() {
        return manutencaoRepository.findByDataServicoBeforeAndStatus(
                LocalDate.now(), StatusManutencao.AGENDADA);
    }

    @Override
    public BigDecimal calcularCustoTotalPorVeiculo(Long veiculoId) {
        List<ManutencaoVeiculo> manutencoes = manutencaoRepository.findByVeiculoId(veiculoId);
        return manutencoes.stream()
                .map(ManutencaoVeiculo::getCustoTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


 */
    // Implementar outros métodos...
}