package br.com.api.emergencias.service.impl;

import br.com.api.emergencias.model.FarmaciaEstoque;
import br.com.api.emergencias.repository.FarmaciaEstoqueRepository;
import br.com.api.emergencias.service.IFarmaciaEstoqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FarmaciaEstoqueService implements IFarmaciaEstoqueService {
    private final FarmaciaEstoqueRepository estoqueRepository;

    @Override
    public FarmaciaEstoque cadastrarItem(FarmaciaEstoque item) {
        if (estoqueRepository.existsByCodigoAndLote(item.getCodigo(), item.getLote())) {
            throw new RuntimeException("Item com mesmo código e lote já existe");
        }
        return estoqueRepository.save(item);
    }
/*
    @Override
    public void ajustarEstoque(Long id, Integer quantidade) {
        FarmaciaEstoque item = estoqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        int novaQuantidade = item.getQuantidade() + quantidade;
        if (novaQuantidade < 0) {
            throw new RuntimeException("Quantidade não pode ser negativa");
        }

        item.setQuantidade(novaQuantidade);
        estoqueRepository.save(item);
    }

    @Override
    public List<FarmaciaEstoque> listarItensBaixoEstoque() {
        return estoqueRepository.findByAtivoTrue().stream()
                .filter(FarmaciaEstoque::isEstoqueBaixo)
                .collect(Collectors.toList());
    }
    */
}