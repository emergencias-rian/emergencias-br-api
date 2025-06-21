package br.com.api.emergencias.service;

import br.com.api.emergencias.model.ServicoManutencao;

import java.math.BigDecimal;
import java.util.List;

public interface IServicoManutencaoService {
    ServicoManutencao adicionarServico(ServicoManutencao servico);
   // List<ServicoManutencao> listarServicosPorManutencao(Long manutencaoId);
    BigDecimal calcularTotalServicos(Long manutencaoId);
    ServicoManutencao atualizarServico(Long id, ServicoManutencao servico);
   // void removerServico(Long id);
}