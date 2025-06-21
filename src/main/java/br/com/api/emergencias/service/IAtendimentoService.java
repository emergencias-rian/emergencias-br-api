package br.com.api.emergencias.service;

import br.com.api.emergencias.enums.StatusAtendimento;
import br.com.api.emergencias.model.Atendimento;

import java.util.List;

public interface IAtendimentoService {
    Atendimento criar(Atendimento atendimento);
   // Atendimento buscarPorProtocolo(String protocolo);
   // List<Atendimento> buscarPorPaciente(Long pacienteId);
   // Atendimento atualizarStatus(Long id, StatusAtendimento status);
   // Atendimento adicionarProfissional(Long id, Long profissionalId);
   // Atendimento adicionarVeiculo(Long id, Long veiculoId);
}