package br.com.api.emergencias.controller;

import br.com.api.emergencias.model.Veiculo;
import br.com.api.emergencias.service.IVeiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculos")
@RequiredArgsConstructor
public class VeiculoController {
    private final IVeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<Veiculo> criar(@RequestBody Veiculo veiculo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoService.salvar(veiculo));
    }

    // outros end points dps
}