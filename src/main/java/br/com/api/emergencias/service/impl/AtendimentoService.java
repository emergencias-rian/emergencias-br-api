package br.com.api.emergencias.service.impl;

import br.com.api.emergencias.model.Atendimento;
import br.com.api.emergencias.repository.AtendimentoRepository;
import br.com.api.emergencias.repository.ClientRepository;
import br.com.api.emergencias.repository.ProfissionalRepository;
import br.com.api.emergencias.repository.VeiculoRepository;
import br.com.api.emergencias.service.IAtendimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AtendimentoService implements IAtendimentoService {
    private final AtendimentoRepository atendimentoRepository;
    private final ClientRepository clienteRepository;
    private final ProfissionalRepository profissionalRepository;
    private final VeiculoRepository veiculoRepository;

    @Override
    public Atendimento criar(Atendimento atendimento) {
        if (atendimentoRepository.existsByProtocolo(atendimento.getProtocolo())) {
            throw new RuntimeException("Protocolo já existe");
        }

        clienteRepository.findById(atendimento.getPaciente().getId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        return atendimentoRepository.save(atendimento);
    }

    // Implementar outros métodos...
}