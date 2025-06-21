package br.com.api.emergencias.service;

import br.com.api.emergencias.enums.FormaPagamento;
import br.com.api.emergencias.enums.StatusFatura;
import br.com.api.emergencias.model.Fatura;

import java.time.LocalDate;
import java.util.List;

public interface IFaturaService {
    Fatura criar(Fatura fatura);
   // Fatura buscarPorNumero(String numeroFatura);
   // List<Fatura> buscarPorCliente(Long clienteId);
  //  Fatura atualizarStatus(Long id, StatusFatura status);
  //  Fatura registrarPagamento(Long id, LocalDate dataPagamento, FormaPagamento formaPagamento);
 //   List<Fatura> buscarFaturasVencidas();
}