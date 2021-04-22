package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUser(Integer id);
    Iterable<User> getAllUsers();
    String deleteUser(Integer id);
}
