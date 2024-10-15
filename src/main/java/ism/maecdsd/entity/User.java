package ism.maecdsd.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = { "login", "password" })
@EqualsAndHashCode(of = { "login" })
public class User {
    private int id;
    private String login;
    private String password;
    private String nom;
    private String prenom;

    // Navigability
    private Client client;

}
