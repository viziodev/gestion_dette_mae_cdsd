package ism.maecdsd.repository.list;


import ism.maecdsd.entity.Client;
import ism.maecdsd.repository.ClientRepository;

public class ClientRepositoryList extends RepositoryListImpl<Client> implements ClientRepository {

    @Override
    public Client readClientBySurname(String surname) {
        for (Client cl : datas) {
            if (cl.getSurname().compareToIgnoreCase(surname) == 0) {
                {
                    return cl;
                }
            }
        }
        return null;
    }

}
