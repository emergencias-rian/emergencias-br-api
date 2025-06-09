package br.com.api.emergencias.service.impl;

import br.com.api.emergencias.model.Cliente;
import br.com.api.emergencias.repository.ClientRepository;
import br.com.api.emergencias.service.IClienteService;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {
    private final ClientRepository clientRepository;

    public ClienteService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    };

    @Override
    public Cliente save(Cliente cliente) {
        return clientRepository.save(cliente);
    }
}
