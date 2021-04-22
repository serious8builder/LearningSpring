package com.example.accessingdatamysql;

import com.example.accessingdatamysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/user")
public class MainController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @PostMapping(path="/add")
    @ResponseBody
    public User addNewUser(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        return userService.createUser(user);
    }

    @GetMapping(path="/all")
    @ResponseBody
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Cacheable(cacheNames = "user")
    @GetMapping(path="/{id}")
    @ResponseBody
    public User getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @GetMapping(path="/del/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable("id") int id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            return String.format("Not deleted for id=%s", id);
        }
        return "deleted";
    }
}
