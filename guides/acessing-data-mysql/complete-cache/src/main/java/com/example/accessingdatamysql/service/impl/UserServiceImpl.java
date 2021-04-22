package com.example.accessingdatamysql.service.impl;

import com.example.accessingdatamysql.User;
import com.example.accessingdatamysql.UserRepository;
import com.example.accessingdatamysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User getUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) return user.get();
        else return null;
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String deleteUser(Integer id) {
        return null;
    }
}
