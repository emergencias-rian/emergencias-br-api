package br.com.api.emergencias.controller;

import br.com.api.emergencias.model.KitAmbulancia;
import br.com.api.emergencias.service.IKitAmbulanciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/kits-ambulancia")
@RequiredArgsConstructor
public class KitAmbulanciaController {
    private final IKitAmbulanciaService kitService;

    @PostMapping
    public ResponseEntity<KitAmbulancia> cadastrarKit(
            @RequestBody KitAmbulancia kit) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(kitService.cadastrarKit(kit));
    }
/*
    @PatchMapping("/{id}/verificacao")
    public ResponseEntity<Void> registrarVerificacao(
            @PathVariable Long id,
            @RequestParam LocalDate dataVerificacao,
            @RequestParam int diasProximaVerificacao) {
        kitService.registrarVerificacao(id, dataVerificacao, diasProximaVerificacao);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/veiculo/{veiculoId}")
    public ResponseEntity<List<KitAmbulancia>> listarPorVeiculo(
            @PathVariable Long veiculoId) {
        return ResponseEntity.ok(kitService.listarKitsPorVeiculo(veiculoId));
    }

    @GetMapping("/para-verificar")
    public ResponseEntity<List<KitAmbulancia>> listarParaVerificacao() {
        return ResponseEntity.ok(kitService.listarKitsParaVerificacao());
    }

 */
}