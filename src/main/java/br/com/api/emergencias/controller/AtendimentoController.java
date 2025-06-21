package br.com.api.emergencias.controller;

import br.com.api.emergencias.enums.StatusAtendimento;
import br.com.api.emergencias.model.Atendimento;
import br.com.api.emergencias.service.IAtendimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atendimentos")
@RequiredArgsConstructor
public class AtendimentoController {
    private final IAtendimentoService atendimentoService;

    @PostMapping
    public ResponseEntity<Atendimento> criar(@RequestBody Atendimento atendimento) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(atendimentoService.criar(atendimento));
    }
/*
    @PatchMapping("/{id}/status")
    public ResponseEntity<Atendimento> atualizarStatus(
            @PathVariable Long id,
            @RequestParam StatusAtendimento status) {
        return ResponseEntity.ok(atendimentoService.atualizarStatus(id, status));
    }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<Atendimento>> buscarPorPaciente(
            @PathVariable Long pacienteId) {
        return ResponseEntity.ok(atendimentoService.buscarPorPaciente(pacienteId));
    }


 */
}