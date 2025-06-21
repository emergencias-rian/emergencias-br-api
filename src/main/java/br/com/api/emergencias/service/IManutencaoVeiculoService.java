package br.com.api.emergencias.service;

import br.com.api.emergencias.enums.StatusManutencao;
import br.com.api.emergencias.model.ManutencaoVeiculo;

import java.math.BigDecimal;
import java.util.List;

public interface IManutencaoVeiculoService {
    ManutencaoVeiculo agendarManutencao(ManutencaoVeiculo manutencao);
  //  ManutencaoVeiculo atualizarStatus(Long id, StatusManutencao status);
  //  List<ManutencaoVeiculo> listarPorVeiculo(Long veiculoId);
   // List<ManutencaoVeiculo> listarManutencoesAtrasadas();
   // List<ManutencaoVeiculo> listarProximasManutencoes();
   // BigDecimal calcularCustoTotalPorVeiculo(Long veiculoId);
}