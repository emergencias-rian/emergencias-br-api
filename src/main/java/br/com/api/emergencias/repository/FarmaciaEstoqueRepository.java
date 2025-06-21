package br.com.api.emergencias.repository;

import br.com.api.emergencias.enums.TipoItemFarmacia;
import br.com.api.emergencias.model.FarmaciaEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FarmaciaEstoqueRepository extends JpaRepository<FarmaciaEstoque, Long> {
    List<FarmaciaEstoque> findByTipo(TipoItemFarmacia tipo);
    // List<FarmaciaEstoque> findByAtivoTrue();
   // List<FarmaciaEstoque> findByQuantidadeLessThan(Integer quantidade);
   // List<FarmaciaEstoque> findByValidadeBefore(LocalDate date);
    boolean existsByCodigoAndLote(String codigo, String lote);
}