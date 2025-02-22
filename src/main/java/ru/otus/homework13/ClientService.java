package ru.otus.homework13;

import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void save(Client client) {
        clientRepository.save(client);
    }
}
