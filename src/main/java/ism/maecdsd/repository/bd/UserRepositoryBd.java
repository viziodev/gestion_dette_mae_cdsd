package ism.maecdsd.repository.bd;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import ism.maecdsd.entity.User;
import ism.maecdsd.repository.UserRepository;

public class UserRepositoryBd implements UserRepository {

    @Override
    public List<User> read() {
        String sql = "SELECT * FROM user";
        List<User> users = new ArrayList<User>();

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/gestion_dette_glrs_2024_b",
                    "root", "root");
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            // Conversiion ResultSet ==> List<Client>
            while (rs.next()) { // Parcours de ligne
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void create(User entity) {
        String sql = "insert into user(nom,prenom,login,password) values (?, ?,?,?)";
        int nbreLigneAffecte = 0;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/gestion_dette_glrs_2024_b",
                    "root", "root");
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, entity.getNom()); // String en Varchar
            ps.setString(2, entity.getPrenom());
            ps.setString(3, entity.getLogin());
            ps.setString(4, entity.getPassword());
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
    public boolean loginExist(String login) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loginExist'");
    }

    @Override
    public void seConnecter(String login, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'seConnecter'");
    }

}
