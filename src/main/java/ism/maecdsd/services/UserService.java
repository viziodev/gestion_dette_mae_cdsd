package ism.maecdsd.services;

import java.util.List;

import ism.maecdsd.entity.User;

public interface UserService {
    public void create(User user);

    public List<User> get();
}
