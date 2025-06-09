package br.com.api.emergencias.controller;

import br.com.api.emergencias.enums.StatusContrato;
import br.com.api.emergencias.model.Contrato;
import br.com.api.emergencias.service.IContratoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contratos")
@RequiredArgsConstructor
public class ContratoController {
    private final IContratoService contratoService;

    @PostMapping
    public ResponseEntity<Contrato> criar(@RequestBody Contrato contrato) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contratoService.criar(contrato));
    }
/*
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Contrato>> buscarPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(contratoService.buscarPorCliente(clienteId));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> atualizarStatus(
            @PathVariable Long id,
            @RequestParam StatusContrato status) {
        contratoService.atualizarStatus(id, status);
        return ResponseEntity.noContent().build();
    }
   
 */
}