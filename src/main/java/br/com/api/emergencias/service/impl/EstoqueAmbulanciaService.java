package br.com.api.emergencias.service.impl;

import br.com.api.emergencias.model.EstoqueAmbulancia;
import br.com.api.emergencias.repository.EstoqueAmbulanciaRepository;
import br.com.api.emergencias.repository.FarmaciaEstoqueRepository;
import br.com.api.emergencias.repository.VeiculoRepository;
import br.com.api.emergencias.service.IEstoqueAmbulanciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstoqueAmbulanciaService implements IEstoqueAmbulanciaService {
    private final EstoqueAmbulanciaRepository estoqueRepository;
    private final VeiculoRepository veiculoRepository;
    private final FarmaciaEstoqueRepository farmaciaEstoqueRepository;

    @Override
    public EstoqueAmbulancia cadastrarItem(EstoqueAmbulancia estoque) {
        // Verifica se a combinação veículo/item já existe
        if (estoqueRepository.existsByVeiculoIdAndItemId(
                estoque.getVeiculo().getId(),
                estoque.getItem().getId())) {
            throw new RuntimeException("Item já cadastrado para esta ambulância");
        }

        // Valida veículo
        veiculoRepository.findById(estoque.getVeiculo().getId())
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        // Valida item de estoque
        farmaciaEstoqueRepository.findById(estoque.getItem().getId())
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        return estoqueRepository.save(estoque);
    }
/*
    @Override
    public void ajustarEstoque(Long id, Integer quantidade) {
        EstoqueAmbulancia estoque = estoqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro de estoque não encontrado"));

        int novaQuantidade = estoque.getQuantidadeAtual() + quantidade;
        if (novaQuantidade < 0) {
            throw new RuntimeException("Quantidade não pode ser negativa");
        }

        estoque.setQuantidadeAtual(novaQuantidade);
        estoqueRepository.save(estoque);
    }


 */
    // Implementar outros métodos...
}