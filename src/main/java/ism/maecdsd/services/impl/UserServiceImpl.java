package ism.maecdsd.services.impl;

import java.util.List;

import ism.maecdsd.entity.User;
import ism.maecdsd.repository.UserRepository;


import ism.maecdsd.services.UserService;

public class UserServiceImpl implements UserService {


    private UserRepository userRepository ;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {
        userRepository.create(user);

    }

    @Override
    public List<User> get() {
        return userRepository.read();
    }
}
