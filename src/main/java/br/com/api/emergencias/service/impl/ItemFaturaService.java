package br.com.api.emergencias.service.impl;

import br.com.api.emergencias.model.ItemFatura;
import br.com.api.emergencias.repository.FaturaRepository;
import br.com.api.emergencias.repository.ItemFaturaRepository;
import br.com.api.emergencias.repository.ServicoRepository;
import br.com.api.emergencias.service.IItemFaturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemFaturaService implements IItemFaturaService {
    private final ItemFaturaRepository itemFaturaRepository;
    private final FaturaRepository faturaRepository;
    private final ServicoRepository servicoRepository;

    @Override
    public ItemFatura criar(ItemFatura itemFatura) {
        // Valida se a fatura existe
        faturaRepository.findById(itemFatura.getFatura().getId())
                .orElseThrow(() -> new RuntimeException("Fatura não encontrada"));

        // Valida se o serviço existe
        servicoRepository.findById(itemFatura.getServico().getId())
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        return itemFaturaRepository.save(itemFatura);
    }
/*
    @Override
    public BigDecimal calcularTotalFatura(Long faturaId) {
        List<ItemFatura> itens = itemFaturaRepository.findByFaturaId(faturaId);
        return itens.stream()
                .map(ItemFatura::getValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


 */
    // Implementar outros métodos...
}