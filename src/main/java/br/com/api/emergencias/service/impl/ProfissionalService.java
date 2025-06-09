package br.com.api.emergencias.service.impl;

import br.com.api.emergencias.model.Profissional;
import br.com.api.emergencias.repository.ProfissionalRepository;
import br.com.api.emergencias.service.IProfissionalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissionalService implements IProfissionalService {

    private final ProfissionalRepository profissionalRepository;

    public ProfissionalService(ProfissionalRepository profissionalRepository) {
        this.profissionalRepository = profissionalRepository;
    }

    @Override
    public Profissional save(Profissional profissional) {
        return profissionalRepository.save(profissional);
    }

    @Override
    public Profissional findById(Long id) {
        return profissionalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));
    }

    @Override
    public List<Profissional> findAll() {
        return profissionalRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        profissionalRepository.deleteById(id);
    }

    @Override
    public Profissional update(Long id, Profissional profissionalAtualizado) {
        return profissionalRepository.findById(id)
                .map(profissionalExistente -> {
                    profissionalExistente.setNome(profissionalAtualizado.getNome());
                    profissionalExistente.setCidade(profissionalAtualizado.getCidade());
                    // Atualize outros campos conforme necessário
                    return profissionalRepository.save(profissionalExistente);
                })
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));
    }
}