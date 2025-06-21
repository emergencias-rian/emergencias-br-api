package br.com.api.emergencias.service;

import br.com.api.emergencias.enums.TipoItemFarmacia;
import br.com.api.emergencias.model.FarmaciaEstoque;

import java.util.List;

public interface IFarmaciaEstoqueService {
    FarmaciaEstoque cadastrarItem(FarmaciaEstoque item);
   // FarmaciaEstoque atualizarItem(Long id, FarmaciaEstoque item);
   // ddvoid ajustarEstoque(Long id, Integer quantidade);
   // List<FarmaciaEstoque> listarItensBaixoEstoque();
   // List<FarmaciaEstoque> listarItensVencidos();
    // List<FarmaciaEstoque> buscarPorTipo(TipoItemFarmacia tipo);
}