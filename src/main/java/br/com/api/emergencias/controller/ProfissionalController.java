package br.com.api.emergencias.controller;

import br.com.api.emergencias.model.Profissional;
import br.com.api.emergencias.service.IProfissionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissionais")
@RequiredArgsConstructor
public class ProfissionalController {
    private final IProfissionalService profissionalService;

    @PostMapping
    public ResponseEntity<Profissional> create(@RequestBody Profissional profissional) {
        return ResponseEntity.status(HttpStatus.CREATED).body(profissionalService.save(profissional));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profissional> getById(@PathVariable Long id) {
        return ResponseEntity.ok(profissionalService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Profissional>> getAll() {
        return ResponseEntity.ok(profissionalService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profissional> update(
            @PathVariable Long id,
            @RequestBody Profissional profissionalAtualizado) {
        return ResponseEntity.ok(profissionalService.update(id, profissionalAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        profissionalService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
