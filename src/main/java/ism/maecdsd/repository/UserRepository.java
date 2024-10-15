package ism.maecdsd.repository;

import ism.maecdsd.core.repository.Repository;
import ism.maecdsd.entity.User;

public interface UserRepository extends Repository<User> {

    public boolean loginExist(String login);
    public void seConnecter(String login, String password);
}
