package org.com.finablr.health.service;

import org.com.finablr.health.entity.User;
import org.com.finablr.health.producer.Sender;
import org.com.finablr.health.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

   // @Value("${spring.kafka.topic.userCreated}")
   // private String USER_CREATED_TOPIC;

    private UserRepository userRepository;
    private Sender sender;

    @Autowired
    UserServiceImpl(UserRepository userRepository, Sender sender) {
        this.userRepository = userRepository;
        this.sender = sender;
    }

    @Override
    public User registerUser(User input) {
        User createdUser = userRepository.save(input);
        sender.send("user_send", createdUser);
        			
        return createdUser;
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}
