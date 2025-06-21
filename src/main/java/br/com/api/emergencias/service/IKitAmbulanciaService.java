package br.com.api.emergencias.service;

import br.com.api.emergencias.model.KitAmbulancia;

import java.time.LocalDate;
import java.util.List;

public interface IKitAmbulanciaService {
    KitAmbulancia cadastrarKit(KitAmbulancia kit);
 //   KitAmbulancia atualizarKit(Long id, KitAmbulancia kit);
  //  void registrarVerificacao(Long id, LocalDate dataVerificacao, int diasProximaVerificacao);
  //  List<KitAmbulancia> listarKitsPorVeiculo(Long veiculoId);
   // List<KitAmbulancia> listarKitsParaVerificacao();
}