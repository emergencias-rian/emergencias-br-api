package br.com.api.emergencias.controller;

import br.com.api.emergencias.model.FarmaciaEstoque;
import br.com.api.emergencias.service.IFarmaciaEstoqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmacia/estoque")
@RequiredArgsConstructor
public class FarmaciaEstoqueController {
    private final IFarmaciaEstoqueService estoqueService;

    @PostMapping
    public ResponseEntity<FarmaciaEstoque> cadastrarItem(
            @RequestBody FarmaciaEstoque item) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(estoqueService.cadastrarItem(item));
    }
/*
    @PatchMapping("/{id}/estoque")
    public ResponseEntity<Void> ajustarEstoque(
            @PathVariable Long id,
            @RequestParam Integer quantidade) {
        estoqueService.ajustarEstoque(id, quantidade);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/baixo-estoque")
    public ResponseEntity<List<FarmaciaEstoque>> listarBaixoEstoque() {
        return ResponseEntity.ok(estoqueService.listarItensBaixoEstoque());
    }

    @GetMapping("/vencidos")
    public ResponseEntity<List<FarmaciaEstoque>> listarVencidos() {
        return ResponseEntity.ok(estoqueService.listarItensVencidos());
    }

 */
}
