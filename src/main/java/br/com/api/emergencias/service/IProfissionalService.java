package br.com.api.emergencias.service;

import br.com.api.emergencias.model.Profissional;

import java.util.List;

public interface IProfissionalService {
    Profissional save(Profissional profissional);
    Profissional findById(Long id);
    List<Profissional> findAll();
    void delete(Long id);
    Profissional update(Long id, Profissional profissionalAtualizado);
}
