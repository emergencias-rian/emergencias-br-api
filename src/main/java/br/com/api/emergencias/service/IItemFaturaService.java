package br.com.api.emergencias.service;

import br.com.api.emergencias.model.ItemFatura;

import java.math.BigDecimal;
import java.util.List;

public interface IItemFaturaService {
    ItemFatura criar(ItemFatura itemFatura);
  //  List<ItemFatura> buscarPorFatura(Long faturaId);
  //  ItemFatura atualizarItem(Long id, Integer quantidade, BigDecimal valorUnitario);
  //  void removerItem(Long id);
  //  BigDecimal calcularTotalFatura(Long faturaId);
}