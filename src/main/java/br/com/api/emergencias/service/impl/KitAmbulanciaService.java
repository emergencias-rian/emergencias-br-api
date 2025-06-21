package br.com.api.emergencias.service.impl;

import br.com.api.emergencias.model.KitAmbulancia;
import br.com.api.emergencias.repository.KitAmbulanciaRepository;
import br.com.api.emergencias.repository.VeiculoRepository;
import br.com.api.emergencias.service.IKitAmbulanciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class KitAmbulanciaService implements IKitAmbulanciaService {
    private final KitAmbulanciaRepository kitRepository;
    private final VeiculoRepository veiculoRepository;

    @Override
    public KitAmbulancia cadastrarKit(KitAmbulancia kit) {
        if (kitRepository.existsByCodigo(kit.getCodigo())) {
            throw new RuntimeException("Código do kit já existe");
        }

        veiculoRepository.findById(kit.getVeiculo().getId())
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        return kitRepository.save(kit);
    }
/*
    @Override
    public void registrarVerificacao(Long id, LocalDate dataVerificacao, int diasProximaVerificacao) {
        KitAmbulancia kit = kitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kit não encontrado"));

        kit.setUltimaVerificacao(dataVerificacao);
        kit.setProximaVerificacao(dataVerificacao.plusDays(diasProximaVerificacao));

        kitRepository.save(kit);
    }


 */
    // outros metodos dps
}