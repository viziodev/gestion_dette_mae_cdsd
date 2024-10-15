package ism.maecdsd.views;

import java.util.List;
import java.util.Scanner;

import ism.maecdsd.entity.Client;
import ism.maecdsd.entity.User;

public class UserView {

    private Scanner scanner;

    public UserView(Scanner scanner) {
        this.scanner = scanner;
    }

    public User saisieUser() {
        User user = new User();

        System.out.println("Entrer le login");
        user.setLogin(scanner.nextLine());
        System.out.println("Entrer le password");
        user.setPassword(scanner.nextLine());
        System.out.println("Entrer le Nom");
        user.setNom(scanner.nextLine());
        System.out.println("Entrer le Prenom");
        user.setPrenom(scanner.nextLine());
        // scanner.close();
        return user;
    }

    public void afficheUser(List<User> users) {
        for (User u : users) {
            System.out.println(u);
        }
    }
}
