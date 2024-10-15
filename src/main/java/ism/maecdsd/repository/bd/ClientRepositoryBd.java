package ism.maecdsd.repository.bd;

import java.util.ArrayList;
import java.util.List;



import ism.maecdsd.entity.Client;
import ism.maecdsd.repository.ClientRepository;

import java.sql.*;

public class ClientRepositoryBd implements ClientRepository {

    @Override
    public List<Client> read() {
        String sql = "SELECT * FROM client";
        List<Client> clients = new ArrayList<Client>();

        // 1-Chargement du Driver ==> Indiquer le SGBD utilise
        // 2-Ouvrir la Connection a la de donnee ==> JDBC ==> Connection
        // server (Macos)localhost:8889 localhost:3306(Windows) ==>Port de Mysql
        // nom bd gestion_dette_glrs_2024_b
        // user connection sur Mysql ==>root
        // password connection sur Mysql ==> root
        // 3-Execution des Requetes ==> PreparedStatement
        // Requte Select ==> retourne des donnees ==> executeQuery() ==> ResultSet
        // Requete Mis a jour(insert,update,delete ) ==> executeUpdate()=> retourner un
        // entier (nbre ligne affectee par requete)

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/gestion_dette_glrs_2024_b",
                    "root", "root");
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            // Conversiion ResultSet ==> List<Client>
            while (rs.next()) { // Parcours de ligne
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setSurname(rs.getString("surname"));
                client.setTelephone(rs.getString("telephone"));
                client.setAdresse(rs.getString("adresse"));
                clients.add(client);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public void create(Client entity) {
        // Requete preparer
        String sql = "insert into client(surname,telephone,adresse) values (?, ?,?)";
        int nbreLigneAffecte = 0;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/gestion_dette_glrs_2024_b",
                    "root", "root");
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, entity.getSurname()); // String en Varchar
            ps.setString(2, entity.getTelephone());
            ps.setString(3, entity.getAdresse());
            // Execution de la requete
            nbreLigneAffecte = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();// SELECT MAX(id) as id FROM `client` WHERE 1;
            if (rs.next()) {
                entity.setId(rs.getInt(1));
            }
            // Conversiion ResultSet ==> List<Client>

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Client readClientBySurname(String surname) {
        // Faille security Injection sql 1
        String sql = "SELECT * FROM client where surname = ?";
        Client client = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/gestion_dette_glrs_2024_b",
                    "root", "root");
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, surname); // String en Varchar
            // Execution de la requete
            ResultSet rs = ps.executeQuery();
            // Conversiion ResultSet ==> List<Client>
            if (rs.next()) { // Parcours de ligne
                client = new Client();
                client.setId(rs.getInt("id"));
                client.setSurname(rs.getString("surname"));
                client.setTelephone(rs.getString("telephone")); // Varchar en string de
                client.setAdresse(rs.getString("adresse"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

}
