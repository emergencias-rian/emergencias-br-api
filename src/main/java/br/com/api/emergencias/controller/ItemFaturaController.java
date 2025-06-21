package br.com.api.emergencias.controller;

import br.com.api.emergencias.model.ItemFatura;
import br.com.api.emergencias.service.IFaturaService;
import br.com.api.emergencias.service.IItemFaturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/itens-fatura")
@RequiredArgsConstructor
public class ItemFaturaController {
    private final IItemFaturaService itemFaturaService;
    private final IFaturaService faturaService;
/*
    @PostMapping
    public ResponseEntity<ItemFatura> criar(@RequestBody ItemFatura itemFatura) {
        ItemFatura itemSalvo = itemFaturaService.criar(itemFatura);

        // Atualiza o valor total da fatura
        BigDecimal novoTotal = itemFaturaService.calcularTotalFatura(itemFatura.getFatura().getId());
        faturaService.atualizarValorTotal(itemFatura.getFatura().getId(), novoTotal);

        return ResponseEntity.status(HttpStatus.CREATED).body(itemSalvo);
    }

    @GetMapping("/fatura/{faturaId}")
    public ResponseEntity<List<ItemFatura>> buscarPorFatura(
            @PathVariable Long faturaId) {
        return ResponseEntity.ok(itemFaturaService.buscarPorFatura(faturaId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerItem(
            @PathVariable Long id) {
        ItemFatura item = itemFaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        itemFaturaService.removerItem(id);

        // Atualiza o valor total da fatura
        BigDecimal novoTotal = itemFaturaService.calcularTotalFatura(item.getFatura().getId());
        faturaService.atualizarValorTotal(item.getFatura().getId(), novoTotal);

        return ResponseEntity.noContent().build();
    }

 */
}