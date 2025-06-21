package br.com.api.emergencias.service.impl;

import br.com.api.emergencias.model.ServicoManutencao;
import br.com.api.emergencias.repository.ManutencaoVeiculoRepository;
import br.com.api.emergencias.repository.ServicoManutencaoRepository;
import br.com.api.emergencias.service.IServicoManutencaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicoManutencaoService implements IServicoManutencaoService {
    private final ServicoManutencaoRepository servicoRepository;
    private final ManutencaoVeiculoRepository manutencaoRepository;

    @Override
    public ServicoManutencao adicionarServico(ServicoManutencao servico) {
        manutencaoRepository.findById(servico.getManutencao().getId())
                .orElseThrow(() -> new RuntimeException("Manutenção não encontrada"));

        if (servico.getCusto().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Custo deve ser maior que zero");
        }

        return servicoRepository.save(servico);
    }
    @Override
    public BigDecimal calcularTotalServicos(Long manutencaoId) {
        manutencaoRepository.findById(manutencaoId)
                .orElseThrow(() -> new RuntimeException("Manutenção não encontrada"));

        List<ServicoManutencao> servicos = servicoRepository.findByManutencaoId(manutencaoId);

        return servicos.stream()
                .map(ServicoManutencao::getCusto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public ServicoManutencao atualizarServico(Long id, ServicoManutencao servico) {
        ServicoManutencao servicoExistente = servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        // Atualiza os campos
        servicoExistente.setDescricao(servico.getDescricao());
        servicoExistente.setCusto(servico.getCusto());

        return servicoRepository.save(servicoExistente);
    }
    // colocar outros metodos dps
}