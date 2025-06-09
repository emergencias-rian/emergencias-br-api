package br.com.api.emergencias.service.impl;

import br.com.api.emergencias.model.Servico;
import br.com.api.emergencias.repository.ServicoRepository;
import br.com.api.emergencias.service.IServicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServicoService implements IServicoService {
    private final ServicoRepository servicoRepository;

    @Override
    public Servico criar(Servico servico) {
        if (servicoRepository.existsByCodigo(servico.getCodigo())) {
            throw new RuntimeException("Código de serviço já existe");
        }
        return servicoRepository.save(servico);
    }

    // outros metodos dps

}