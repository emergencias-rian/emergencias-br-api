package br.com.api.emergencias.service.impl;

import br.com.api.emergencias.model.Agenda;
import br.com.api.emergencias.repository.AgendaRepository;
import br.com.api.emergencias.service.IAgendaService;
import org.springframework.stereotype.Service;

@Service
public class AgendaService implements IAgendaService {

    private final AgendaRepository agendaRepository;

    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    @Override
    public Agenda save(Agenda agenda) {
        return agendaRepository.save(agenda);
    }
}
