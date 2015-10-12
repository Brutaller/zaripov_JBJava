package ru.kpfu.itis.service;

import ru.kpfu.itis.model.User;

import java.util.List;

/**
 * Created by Azat Zaripov on 10.10.2015.
 */
public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

}
