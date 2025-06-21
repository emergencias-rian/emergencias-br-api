package br.com.api.emergencias.repository;


import br.com.api.emergencias.model.ItemFatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemFaturaRepository extends JpaRepository<ItemFatura, Long> {
    List<ItemFatura> findByFaturaId(Long faturaId);
    List<ItemFatura> findByServicoId(Long servicoId);
}