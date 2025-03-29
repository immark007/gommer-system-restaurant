package io.mark.api.github.goomer.service;

import io.mark.api.github.goomer.model.Client;
import io.mark.api.github.goomer.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;


    public Client create(Client client) {
        return clientRepository.save(client);
    }

    public Client obterPorClientId(String clientId) {
        return clientRepository.findByClientId(clientId);
    }
}
