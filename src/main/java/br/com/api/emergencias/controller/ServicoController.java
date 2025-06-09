package br.com.api.emergencias.controller;

import br.com.api.emergencias.model.Servico;
import br.com.api.emergencias.service.IServicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
@RequiredArgsConstructor
public class ServicoController {
    private final IServicoService servicoService;

    @PostMapping
    public ResponseEntity<Servico> criar(@RequestBody Servico servico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicoService.criar(servico));
    }
/*
    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<Servico> buscarPorCodigo(@PathVariable String codigo) {
        return ResponseEntity.ok(servicoService.buscarPorCodigo(codigo));
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<Servico>> listarAtivos() {
        return ResponseEntity.ok(servicoService.listarAtivos());
    }
*/
    // Outros endpoints...
}