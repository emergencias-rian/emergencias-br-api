package br.com.api.emergencias.service.impl;

import br.com.api.emergencias.model.Contrato;
import br.com.api.emergencias.repository.ClientRepository;
import br.com.api.emergencias.repository.ContratoRepository;
import br.com.api.emergencias.service.IContratoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContratoService implements IContratoService {
    private final ContratoRepository contratoRepository;
    private final ClientRepository clienteRepository;

    @Override
    public Contrato criar(Contrato contrato) {
        if (contratoRepository.existsByNumeroContrato(contrato.getNumeroContrato())) {
            throw new RuntimeException("Número de contrato já existe");
        }

        // Verifica se o cliente existe
        clienteRepository.findById(contrato.getCliente().getId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return contratoRepository.save(contrato);
    }

    // lançar outros dps
}
