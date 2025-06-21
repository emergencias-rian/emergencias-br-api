package br.com.api.emergencias.service.impl;

import br.com.api.emergencias.model.ItemKitAmbulancia;
import br.com.api.emergencias.repository.FarmaciaEstoqueRepository;
import br.com.api.emergencias.repository.ItemKitAmbulanciaRepository;
import br.com.api.emergencias.repository.KitAmbulanciaRepository;
import br.com.api.emergencias.service.IItemKitAmbulanciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemKitAmbulanciaService implements IItemKitAmbulanciaService {
    private final ItemKitAmbulanciaRepository itemKitRepository;
    private final KitAmbulanciaRepository kitRepository;
    private final FarmaciaEstoqueRepository estoqueRepository;

    @Override
    public ItemKitAmbulancia adicionarItem(ItemKitAmbulancia item) {

        kitRepository.findById(item.getKit().getId())
                .orElseThrow(() -> new RuntimeException("Kit não encontrado"));


        estoqueRepository.findById(item.getItemEstoque().getId())
                .orElseThrow(() -> new RuntimeException("Item de estoque não encontrado"));

        return itemKitRepository.save(item);
    }
/*
    @Override
    public List<ItemKitAmbulancia> listarItensProximosVencimento() {
        LocalDate hoje = LocalDate.now();
        return itemKitRepository.findByValidadeBetween(hoje, hoje.plusDays(30));
    }
*/
    // Implementar outros métodos...
}