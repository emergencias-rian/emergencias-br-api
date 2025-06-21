package br.com.api.emergencias.service;

import br.com.api.emergencias.model.EstoqueAmbulancia;

import java.util.List;

public interface IEstoqueAmbulanciaService {
    EstoqueAmbulancia cadastrarItem(EstoqueAmbulancia estoque);
   // EstoqueAmbulancia atualizarItem(Long id, EstoqueAmbulancia estoque);
   // void ajustarEstoque(Long id, Integer quantidade);
   // List<EstoqueAmbulancia> listarPorVeiculo(Long veiculoId);
   // List<EstoqueAmbulancia> listarItensBaixoEstoque();
   // List<EstoqueAmbulancia> listarItensParaVerificacao();
   // void registrarReposicao(Long id, Integer quantidade);
}