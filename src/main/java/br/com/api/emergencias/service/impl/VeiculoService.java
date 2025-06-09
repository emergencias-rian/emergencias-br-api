package br.com.api.emergencias.service.impl;

import br.com.api.emergencias.model.Veiculo;
import br.com.api.emergencias.repository.VeiculoRepository;
import br.com.api.emergencias.service.IVeiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VeiculoService implements IVeiculoService {
    private final VeiculoRepository veiculoRepository;

    @Override
    public Veiculo salvar(Veiculo veiculo) {
        if(veiculoRepository.existsByPlaca(veiculo.getPlaca())) {
            throw new RuntimeException("Placa já cadastrada");
        }
        return veiculoRepository.save(veiculo);
    }


}