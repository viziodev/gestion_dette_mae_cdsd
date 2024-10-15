package ism.maecdsd.repository;

import ism.maecdsd.core.repository.Repository;
import ism.maecdsd.entity.Client;


public interface ClientRepository extends Repository<Client> {
    // Methodes abstraites
    public Client readClientBySurname(String surname);
}
