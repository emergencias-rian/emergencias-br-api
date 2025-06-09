package br.com.api.emergencias.repository;

import br.com.api.emergencias.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    boolean existsByPlaca(String placa);
    Veiculo findByPlaca(String placa);
}