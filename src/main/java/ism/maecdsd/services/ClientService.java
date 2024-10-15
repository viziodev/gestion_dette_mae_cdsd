package ism.maecdsd.services;

import ism.maecdsd.entity.Client;
import java.util.List;
public interface ClientService {
      public void create(Client client) ;
      public Client surnameExist(String surname) ;
      public List<Client> get();
}
