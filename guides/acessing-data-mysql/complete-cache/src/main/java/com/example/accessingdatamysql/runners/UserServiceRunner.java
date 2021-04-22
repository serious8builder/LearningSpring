package com.example.accessingdatamysql.runners;

import com.example.accessingdatamysql.User;
import com.example.accessingdatamysql.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserServiceRunner implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(UserServiceRunner.class);
    private static Logger logger2 =  LogManager.getLogger(UserServiceRunner.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        logger.info("--------< UserService Runner >--------");
        Optional<User> user = userRepository.findById(3);

    }
}
