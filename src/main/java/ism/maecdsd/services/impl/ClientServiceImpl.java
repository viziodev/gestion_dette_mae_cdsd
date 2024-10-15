package ism.maecdsd.services.impl;

import java.util.List;

import ism.maecdsd.entity.Client;
import ism.maecdsd.repository.ClientRepository;
import ism.maecdsd.services.ClientService;

public class ClientServiceImpl implements ClientService {
    // Dependance ClientServiceImpl depend ClientRepositoryList
    // 1-Creer la dependance
      //Couplage Fort
      // private ClientRepositoryList clientRepositoryList = new ClientRepositoryList();
       // L: Liskow ==> Couplage Faible
 
        private ClientRepository clientRepository ;
        
     //Injection de Dependance
      public ClientServiceImpl(ClientRepository clientRepository) {
            this.clientRepository = clientRepository;
        }

    // 2-Realiser les Use case du Client
    @Override
    public void create(Client client) {
        clientRepository.create(client);

    }

    @Override
    public Client surnameExist(String surname) {
        return clientRepository.readClientBySurname(surname);
    }

    @Override
    public List<Client> get() {
        return clientRepository.read();
    }
}
