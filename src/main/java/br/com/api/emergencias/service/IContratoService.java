package br.com.api.emergencias.service;

import br.com.api.emergencias.enums.StatusContrato;
import br.com.api.emergencias.model.Contrato;

import java.time.LocalDate;
import java.util.List;

public interface IContratoService {
    Contrato criar(Contrato contrato);
   // Contrato buscarPorId(Long id);
   // List<Contrato> buscarPorCliente(Long clienteId);
   // Contrato atualizar(Long id, Contrato contratoAtualizado);
   // void atualizarStatus(Long id, StatusContrato novoStatus);
   // List<Contrato> listarVencendoEm(LocalDate dataInicio, LocalDate dataFim);
}