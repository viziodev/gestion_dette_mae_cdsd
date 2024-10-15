package ism.maecdsd;

import java.util.Scanner;

import ism.maecdsd.entity.Client;
import ism.maecdsd.entity.User;
import ism.maecdsd.repository.ClientRepository;
import ism.maecdsd.repository.bd.ClientRepositoryBd;
import ism.maecdsd.repository.bd.UserRepositoryBd;
import ism.maecdsd.services.ClientService;
import ism.maecdsd.services.impl.ClientServiceImpl;
import ism.maecdsd.services.impl.UserServiceImpl;
import ism.maecdsd.views.ClientView;
import ism.maecdsd.views.UserView;

public class Main {
    public static void main(String[] args) {
        int choix;
        // Factory
        Scanner scanner = new Scanner(System.in);
        ClientView clientView = new ClientView(scanner);
        UserView userView = new UserView(scanner);
        Client client;
        User user;
        ClientRepository clientRepository = new ClientRepositoryBd();
        ClientService clientServiceImpl = new ClientServiceImpl(clientRepository);
        UserServiceImpl userServiceImpl = new UserServiceImpl(new UserRepositoryBd());
        do {
            System.out.println("1-Creer un Nouveau Client");
            System.out.println("2-Lister les Client");
            System.out.println("3-Creer un Nouveau User");
            System.out.println("4-Lister les Users");
            System.out.println("5-Quitter");
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    client = clientView.saisieClient();
                    if (clientServiceImpl.surnameExist(client.getSurname()) == null) {
                        clientServiceImpl.create(client);
                    } else {
                        System.out.println("Client exsist: " + client.getSurname());
                    }

                    break;
                case 2:
                    clientView.afficheClient(clientServiceImpl.get());
                    break;
                case 3:
                    user = userView.saisieUser();
                    userServiceImpl.create(user);
                    break;
                case 4:
                    userView.afficheUser(userServiceImpl.get());
                    break;
                default:
                    break;
            }

        } while (choix != 5);

        scanner.close();
    }
}