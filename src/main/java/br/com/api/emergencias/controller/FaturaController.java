package br.com.api.emergencias.controller;

import br.com.api.emergencias.enums.FormaPagamento;
import br.com.api.emergencias.model.Fatura;
import br.com.api.emergencias.service.IFaturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/faturas")
@RequiredArgsConstructor
public class FaturaController {
    private final IFaturaService faturaService;

    @PostMapping
    public ResponseEntity<Fatura> criar(@RequestBody Fatura fatura) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(faturaService.criar(fatura));
    }
/*
    @PatchMapping("/{id}/pagar")
    public ResponseEntity<Fatura> registrarPagamento(
            @PathVariable Long id,
            @RequestParam LocalDate dataPagamento,
            @RequestParam FormaPagamento formaPagamento) {
        return ResponseEntity.ok(
                faturaService.registrarPagamento(id, dataPagamento, formaPagamento));
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Fatura>> buscarPorCliente(
            @PathVariable Long clienteId) {
        return ResponseEntity.ok(faturaService.buscarPorCliente(clienteId));
    }


 */
}