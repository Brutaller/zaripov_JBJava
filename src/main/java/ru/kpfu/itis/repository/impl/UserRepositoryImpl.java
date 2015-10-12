package ru.kpfu.itis.repository.impl;


import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    List<User> users = new ArrayList<User>();

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
