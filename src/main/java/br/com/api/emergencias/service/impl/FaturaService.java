package br.com.api.emergencias.service.impl;

import br.com.api.emergencias.enums.FormaPagamento;
import br.com.api.emergencias.enums.StatusFatura;
import br.com.api.emergencias.model.Fatura;
import br.com.api.emergencias.repository.AtendimentoRepository;
import br.com.api.emergencias.repository.ClientRepository;
import br.com.api.emergencias.repository.FaturaRepository;
import br.com.api.emergencias.service.IFaturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class FaturaService implements IFaturaService {
    private final FaturaRepository faturaRepository;
    private final ClientRepository clienteRepository;
    private final AtendimentoRepository atendimentoRepository;

    @Override
    public Fatura criar(Fatura fatura) {
        if (faturaRepository.existsByNumeroFatura(fatura.getNumeroFatura())) {
            throw new RuntimeException("Número de fatura já existe");
        }

        clienteRepository.findById(fatura.getCliente().getId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        if (fatura.getAtendimento() != null) {
            atendimentoRepository.findById(fatura.getAtendimento().getId())
                    .orElseThrow(() -> new RuntimeException("Atendimento não encontrado"));
        }

        return faturaRepository.save(fatura);
    }
/*
    @Override
    public Fatura registrarPagamento(Long id, LocalDate dataPagamento, FormaPagamento formaPagamento) {
        Fatura fatura = faturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fatura não encontrada"));

        fatura.setDataPagamento(dataPagamento);
        fatura.setFormaPagamento(formaPagamento);
        fatura.setStatus(StatusFatura.PAGO);

        return faturaRepository.save(fatura);
    }
*/
    // Implementar outros métodos...
}