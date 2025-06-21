package br.com.api.emergencias.controller;

import br.com.api.emergencias.model.ItemKitAmbulancia;
import br.com.api.emergencias.service.IItemKitAmbulanciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kits-ambulancia/itens")
@RequiredArgsConstructor
public class ItemKitAmbulanciaController {
    private final IItemKitAmbulanciaService itemKitService;

    @PostMapping
    public ResponseEntity<ItemKitAmbulancia> adicionarItem(
            @RequestBody ItemKitAmbulancia item) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(itemKitService.adicionarItem(item));
    }
/*
    @GetMapping("/kit/{kitId}")
    public ResponseEntity<List<ItemKitAmbulancia>> listarItensPorKit(
            @PathVariable Long kitId) {
        return ResponseEntity.ok(itemKitService.listarItensPorKit(kitId));
    }

    @GetMapping("/proximos-vencimento")
    public ResponseEntity<List<ItemKitAmbulancia>> listarProximosVencimento() {
        return ResponseEntity.ok(itemKitService.listarItensProximosVencimento());
    }

    @PatchMapping("/{id}/quantidade")
    public ResponseEntity<ItemKitAmbulancia> atualizarQuantidade(
            @PathVariable Long id,
            @RequestParam Integer quantidade) {
        return ResponseEntity.ok(itemKitService.atualizarQuantidade(id, quantidade));
    }

 */
}