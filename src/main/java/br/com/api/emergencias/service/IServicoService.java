package br.com.api.emergencias.service;

import br.com.api.emergencias.model.Servico;

import java.util.List;

public interface IServicoService {
    Servico criar(Servico servico);
   // Servico buscarPorId(Long id);
   // Servico buscarPorCodigo(String codigo);
   // List<Servico> listarTodos();
   // List<Servico> listarAtivos();
   // Servico atualizar(Long id, Servico servicoAtualizado);
   // void desativar(Long id);
}